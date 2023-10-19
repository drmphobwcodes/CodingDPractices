package DayInterview;
import java.util.*;

    interface TimeProvider {
        long getCurrentMillis();
    }

    public class TimedKeyValueStoreGPT<K, V> {
        private class Entry implements Comparable<Entry> {
            K key;
            V value;
            long ttlEnd;

            Entry(K key, V value, long ttl) {
                this.key = key;
                this.value = value;
                this.ttlEnd = timeProvider.getCurrentMillis() + ttl;
            }

            @Override
            public int compareTo(Entry other) {
                return Long.compare(this.ttlEnd, other.ttlEnd);
            }
        }

        private int capacity;
        private HashMap<K, Entry> store;
        private PriorityQueue<Entry> ttlQueue;
        private TimeProvider timeProvider;

        public TimedKeyValueStoreGPT(int capacity, TimeProvider timeProvider) {
            this.capacity = capacity;
            this.store = new HashMap<>();
            this.ttlQueue = new PriorityQueue<>();
            this.timeProvider = timeProvider;
        }

        public void add(K key, V value, long ttl) {
            if (ttl <= 0) return;

            if (store.containsKey(key)) {
                Entry oldEntry = store.get(key);
                store.remove(key);
                ttlQueue.remove(oldEntry);
            } else if (store.size() == capacity) {
                Entry oldest = ttlQueue.peek();
                if (oldest != null && oldest.ttlEnd <= timeProvider.getCurrentMillis() + ttl) return;
                ttlQueue.poll();
                store.remove(oldest.key);
            }

            Entry entry = new Entry(key, value, ttl);
            store.put(key, entry);
            ttlQueue.add(entry);
        }

        public V retrieve(K key) {
            Entry entry = store.get(key);

            if (entry == null || entry.ttlEnd <= timeProvider.getCurrentMillis()) {
                store.remove(key);
                ttlQueue.remove(entry);
                return null;
            }

            return entry.value;
        }

        public int size() {
            return store.size();
        }

        public static void main(String[] args) {
            TimeProvider mockTimeProvider = new TimeProvider() {
                long fakeCurrentMillis = 0;

                @Override
                public long getCurrentMillis() {
                    return fakeCurrentMillis;
                }
            };

            TimedKeyValueStoreGPT<String, String> store = new TimedKeyValueStore<>(2, mockTimeProvider);

            store.add("name", "John", 1000);
            System.out.println(store.retrieve("name")); // Outputs: John

            ((TimeProvider)mockTimeProvider).fakeCurrentMillis += 1100;
            System.out.println(store.retrieve("name")); // Outputs: null

            store.add("age", "25", 3000);
            store.add("country", "US", 2000);
            System.out.println(store.size());  // Outputs: 2

            store.add("city", "NY", 1500);  // Shouldn't add because its TTL is lower than others
            System.out.println(store.size());  // Outputs: 2
        }
    }


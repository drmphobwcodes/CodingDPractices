package DayInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TimedKeyValueStore {
    private int capacity;
    private Map<String, Integer> map;
    private PriorityQueue<Map.Entry<String, Integer>> pq;

    public TimedKeyValueStore(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    }

    public void add(String key, int value, long timeToLeave) {
        if (map.containsKey(key)) {
            map.put(key, value);
        } else if (map.size() < capacity) {
            map.put(key, value);
            pq.add(new HashMap.Entry<>(key, value) {
                @Override
                public String getKey() {
                    return null;
                }

                @Override
                public Integer getValue() {
                    return null;
                }

                @Override
                public Integer setValue(Integer value) {
                    return null;
                }

                @Override
                public boolean equals(Object o) {
                    return false;
                }

                @Override
                public int hashCode() {
                    return 0;
                }
            });
        } else {
            Map.Entry<String, Integer> entry = pq.poll();
            if (entry.getValue() < timeToLeave) {
                map.remove(entry.getKey());
                map.put(key, value);
                pq.add(new HashMap.Entry<>(key, value));
            } else {
                map.put(key, value);
            }
        }
    }

    public int get(String key) {
        return map.get(key);
    }

    public int size() {
        return map.size();
    }
}


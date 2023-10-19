import java.util.Stack;
import java.util.LinkedList;

public class Solution {

        private LinkedList<Stack<Integer>> transactions;

        public Solution() {
            this.transactions = new LinkedList<>();
            transactions.add(new Stack<>());
        }

        public void push(int value) {
            if (value < 1 || value > 1_000_000_000) {
                throw new IllegalArgumentException("Value out of range");
            }
            transactions.getLast().push(value);
        }

        public Integer pop() {
            if (transactions.getLast().isEmpty() && transactions.size() == 1) {
                throw new IllegalStateException("Stack is empty");
            }

            while (transactions.getLast().isEmpty() && transactions.size() > 1) {
                transactions.removeLast();
            }

            return transactions.getLast().pop();
        }

        public Integer top() {
            if (transactions.getLast().isEmpty() && transactions.size() == 1) {
                return null;
            }

            while (transactions.getLast().isEmpty() && transactions.size() > 1) {
                transactions.removeLast();
            }

            return transactions.getLast().peek();
        }

        public void begin() {
            transactions.add(new Stack<>());
        }

        public void rollback() {
            if (transactions.size() > 1) {
                transactions.removeLast();
            } else {
                throw new IllegalStateException("No transaction to rollback");
            }
        }

        public void commit() {
            if (transactions.size() == 1) {
                throw new IllegalStateException("No transaction to commit");
            }

            Stack<Integer> topTransaction = transactions.removeLast();
            while (!topTransaction.isEmpty()) {
                transactions.getLast().push(topTransaction.pop());
            }
        }

        public static void main(String[] args) {
            TransactionalStack ts = new TransactionalStack();
            ts.push(5);
            ts.push(10);
            ts.begin();
            ts.push(15);
            System.out.println(ts.top());  // Outputs: 15
            ts.rollback();
            System.out.println(ts.top());  // Outputs: 10
            ts.begin();
            ts.push(20);
            ts.commit();
            System.out.println(ts.pop());  // Outputs: 20
            System.out.println(ts.pop());  // Outputs: 10
        }
    }

}

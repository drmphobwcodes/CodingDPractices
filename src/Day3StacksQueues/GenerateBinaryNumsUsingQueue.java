package Day3StacksQueues;

public class GenerateBinaryNumsUsingQueue {
    //generate binary numbers from 1 to n using a queue
    //https://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/

    public static void main(String[] args) {
        int n = 10;
        generateBinaryNums(n);
    }

    public static void generateBinaryNums(int n) {
        Queue<String> q = new Queue<>();
        q.enqueue("1");

        while(n-- > 0) {
            String s1 = q.dequeue();
            System.out.println(s1);

            String s2 = s1;

            q.enqueue(s1 + "0");
            q.enqueue(s2 + "1");
        }
    }
}

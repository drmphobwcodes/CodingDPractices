package Day3StacksQueues;

public class StackArray {
    //implement a stack using an array

    private int[] arr;
    private int top;
    private int capacity;

    public StackArray(int capacity) {
        this.arr = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }
}

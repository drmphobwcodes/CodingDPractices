package Day3StacksQueues;

public class QueueUsingStacks {
    //implement a queue using two stacks

    private StackArray stack1;
    private StackArray stack2;

    public QueueUsingStacks(int capacity) {
        this.stack1 = new StackArray(capacity);
        this.stack2 = new StackArray(capacity);
    }

    public void enqueue(int data) {
        this.stack1.push(data);
    }

    public int dequeue() {
        if(this.stack2.isEmpty()) {
            while(!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }

        return this.stack2.pop();
    }

    public int peek() {
        if(this.stack2.isEmpty()) {
            while(!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }

        return this.stack2.peek();
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    public boolean isFull() {
        return this.stack1.isFull() || this.stack2.isFull();
    }
}

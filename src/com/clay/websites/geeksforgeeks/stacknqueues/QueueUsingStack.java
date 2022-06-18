package websites.geeksforgeeks.stacknqueues;

import java.util.Stack;

//Implement A Queue Using Stacks
public class QueueUsingStack {
    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(1);
        queueUsingStack.enqueue(2);
        queueUsingStack.enqueue(3);
        queueUsingStack.enqueue(4);
        queueUsingStack.enqueue(5);
        queueUsingStack.enqueue(6);
        queueUsingStack.enqueue(7);
        queueUsingStack.enqueue(8);
        queueUsingStack.dequeue();
        System.out.println(queueUsingStack.dequeue());
    }

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

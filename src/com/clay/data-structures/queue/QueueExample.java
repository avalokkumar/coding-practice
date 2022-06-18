package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        queue.add("F");
        queue.add("G");
        queue.add("H");
        queue.add("I");
        queue.add("J");
        queue.add("K");

        System.out.println("Queue: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("Queue: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("Queue: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("Queue: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("Queue: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("Queue: " + queue);
        System.out.println("poll: " + queue.poll());
        System.out.println("Queue: " + queue);
    }
}

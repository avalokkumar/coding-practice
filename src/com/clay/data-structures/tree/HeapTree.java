package tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class HeapTree {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(21);
        queue.add(25);
    }
}

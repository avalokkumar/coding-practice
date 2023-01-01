package datastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * <p>
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 */
public class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public static void main(String[] args) {
        MedianFinder mfd = new MedianFinder();
        mfd.addNum(1);
        mfd.addNum(2);

        System.out.println(mfd.findMedian());
        mfd.addNum(3);
        System.out.println(mfd.findMedian());
    }

    public MedianFinder() {
        minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.add(num);

        if ((maxHeap.size() - minHeap.size() > 1)
                || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;

        } else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();

        } else {
            return (double) minHeap.peek();
        }
    }
}

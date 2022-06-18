package array;

//Implement a min heap tree
public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (parent >= 0 && heap[parent] > heap[index]) {
            swap(parent, index);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < size && heap[left] < heap[index]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {

        //get test data for min heap
        int[] testData = {5, 3, 1, 4, 2};
        MinHeap minHeap = new MinHeap(testData.length);
        for (int i = 0; i < testData.length; i++) {
            minHeap.insert(testData[i]);
        }
        System.out.println("Min heap: " + minHeap);
        System.out.println("Peek: " + minHeap.peek());
        System.out.println("Remove: " + minHeap.remove());
        System.out.println("Min heap: " + minHeap);

        System.out.println("Iterate min heap: ");
        iterateMinHeap(minHeap);
    }

    private static void iterateMinHeap(MinHeap minHeap) {
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
        }
    }
}

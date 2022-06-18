package websites.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeapTree {

	private static int size = 0;
	private static int capacity = 10;
	private static int heapTree[] = new int[capacity];

	static int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}

	static int getRightChildIndex(int index) {
		return index * 2 + 2;
	}

	static int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	static int getLeftChildNode(int index) {
		return heapTree[getLeftChildIndex(index)];
	}

	static int getRightChildNode(int index) {
		return heapTree[getRightChildIndex(index)];
	}

	static int getParentNode(int index) {
		return heapTree[getParentIndex(index)];
	}

	static boolean hasLeftChildNode(int index) {
		return getLeftChildIndex(index) < size;
	}

	static boolean hasRightChildNode(int index) {
		return getRightChildIndex(index) < size;
	}

	static boolean hasParentNode(int index) {
		return getParentIndex(index) >= 0;
	}

	static int peek(int index) {
		return heapTree[index];
	}

	static void swap(int index1, int index2) {
		int temp = heapTree[index1];
		heapTree[index1] = heapTree[index2];
		heapTree[index2] = temp;
	}

	static void manageCapacity() {
		if (size == capacity) {
			heapTree = Arrays.copyOf(heapTree, capacity * 2);
			capacity *= 2;
		}
	}

	static int poll() {
		if (size == 0) {
			throw new IllegalAccessError();
		}
		int value = heapTree[0];
		heapTree[0] = heapTree[size - 1];
		size--;
		heapifyDown();
		return value;
	}

	static void add(int value) {

		manageCapacity();
		heapTree[size] = value;
		size++;
		heapifyUp();

	}

	private static void heapifyUp() {

		int index = size - 1;

		while (hasParentNode(index) && getParentNode(index) > heapTree[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private static void heapifyDown() {

		int index = 0;

		while (hasLeftChildNode(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChildNode(index) && getRightChildNode(index) < getLeftChildNode(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if (heapTree[index] > heapTree[smallerChildIndex]) {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}

	}

	public static void main(String[] args) {
		int ch;
		Scanner s1 = new Scanner(System.in);

		while (true) {
			System.out.println(
					"Press:\n\t1> Add node to tree\n\t2> Peek Node in tree\n\t3> Poll node from tree\n\t4> View all nodes in tree\n\t5> Exit\n\n");
			ch = s1.nextInt();
			switch (ch) {
			case 1:
				int value = s1.nextInt();
				add(value);
				break;

			case 2:
				System.out.println("Enter the index to view the value");
				int index = s1.nextInt();
				System.out.println(peek(index));
				break;
			case 3:
				System.out.println(poll());

			case 4:
				for (int i = 0; i < size; i++) {
					System.out.println(heapTree[i]+" ");
				}
				break;
			case 5:
				s1.close();
				System.exit(0);

			}
		}
	}

}

package linkedlist;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of
 * a singly linked list.
 *
 */
public class Demo2 {

	private static void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		int k = 3;
		Node head = new Node(11);
		head.next = new Node(29);
		head.next.next = new Node(23);
		head.next.next.next = new Node(81);
		head.next.next.next.next = new Node(15);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(53);
		head.next.next.next.next.next.next.next = new Node(44);
		head.next.next.next.next.next.next.next.next = new Node(29);
		printLL(head);
		for (int i = 0; i < k-1; i++) {
			head = head.next;
		}
		System.out.println();
		printLL(head);

	}
}
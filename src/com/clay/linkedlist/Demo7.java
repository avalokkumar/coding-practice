package linkedlist;

/**
 * Reverse in linked list
 *
 */
public class Demo7 {

	private static Node head;

	private static void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private static void reverseLL(Node temp) {

		if (temp == null) {
			return;
		}
		if (temp.next == null) {
			head = temp;
			return;
		}

		reverseLL(temp.next);
		temp.next.next = temp;
		temp.next = null;
	}

	/*
	 * s s s s f f 11 29 23 81 15 6 53 44 29
	 */
	public static void main(String[] args) {
		head = new Node(11);
		head.next = new Node(29);
		head.next.next = new Node(23);
		head.next.next.next = new Node(81); //
		head.next.next.next.next = new Node(15);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(53);
		head.next.next.next.next.next.next.next = new Node(78);
		// head.next.next.next.next.next.next.next = new Node(29);
		printLL(head);
		reverseLL(head);
		System.out.println();
		printLL(head);
	}
}

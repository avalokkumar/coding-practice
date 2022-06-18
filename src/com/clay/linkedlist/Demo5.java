package linkedlist;

/**
 * Check loop in linked list
 *
 */
public class Demo5 {

	private static boolean checkLoop(Node head) {

		Node slow = head;
		Node fast = head.next;
		
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}

		return false;
	}

	/*
	 * s s s s f f 11 29 23 81 15 6 53 44 29
	 */
	public static void main(String[] args) {
		Node head = new Node(11);
		head.next = new Node(29);
		head.next.next = new Node(23);
		head.next.next.next = new Node(81); //
		head.next.next.next.next = new Node(15);
		//head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(53);
		head.next.next.next.next.next.next.next = head.next.next.next;
		//head.next.next.next.next.next.next.next = new Node(29);

		System.out.println(checkLoop(head));
	}
}

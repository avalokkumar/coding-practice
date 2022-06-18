package linkedlist;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact
 * middle) of a singly linked list, given only access to that node
 *
 */
public class Demo3 {

	private static void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private static void deleteMiddleNode(Node head) {

		Node fast = head;
		Node slow = head;
		Node prev = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = prev.next.next;
	}

	/* s   s  s	s		f	  f
	 * 11 29 23 81 15 6 53 44 29 
	 */
	public static void main(String[] args) {
		Node head = new Node(11);
		head.next = new Node(29);
		head.next.next = new Node(23);
		head.next.next.next = new Node(81);
		head.next.next.next.next = new Node(15);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(53);
		head.next.next.next.next.next.next.next = new Node(44);
		//head.next.next.next.next.next.next.next.next = new Node(29);

		printLL(head);
		System.out.println();
		deleteMiddleNode(head);
		printLL(head);
	}
}

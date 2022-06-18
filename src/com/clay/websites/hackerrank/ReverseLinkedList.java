package websites.hackerrank;

public class ReverseLinkedList {

	private static void reverseLinkedList(Node head) {

		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev.next = null;
			prev = curr;
			curr = temp;
		}
		head = prev;
		printLinkedList(head);
	}

	private static void printLinkedList(Node head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public static void main(String[] args) {

		Node head = new Node(1, null);
		head.next = new Node(2, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);
		head.next.next.next.next = new Node(5, null);

		printLinkedList(head);
		reverseLinkedList(head);
		System.out.println();
		printLinkedList(head);
	}
}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
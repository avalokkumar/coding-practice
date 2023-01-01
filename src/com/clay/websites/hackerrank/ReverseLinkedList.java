package websites.hackerrank;

import algods.linkedlist.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(1, null);
		head.next = new Node(0, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);
		head.next.next.next.next = new Node(0, null);
		head.next.next.next.next.next = new Node(1, null);
////1,0,3,4,0,1
		Node.printLinkedList(head);
		reverseLinkedList(head);
	}

	private static void reverseLinkedList(Node head) {
////1,0,3,4,0,1
		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		Node.printLinkedList(head);
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static ListNode reverseRec(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode ll = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return ll;
	}
}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public static void printLinkedList(Node head) {

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}


package linkedlist;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 *
 * Ex:11 29 23 44 15 6 23 44 ---> 11 29 23 44 15 6
 */
public class Demo1 {

	private static void removeDuplicates(Node head) {
		HashSet<Integer> set = new HashSet<>();
		Node prev = head;
		Node curr = head.next;
		set.add(head.data);

		while (curr != null) {
			// Node next = curr.next;
			if (set.add(curr.data)) {
				prev = curr;
				curr = curr.next;
			} else {
				prev.next = curr.next;
				curr = prev.next;
			}
		}
	}

	static void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(11);
		head.next = new Node(29);
		head.next.next = new Node(23);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(15);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(23);
		head.next.next.next.next.next.next.next = new Node(44);
		head.next.next.next.next.next.next.next.next = new Node(29);
		printLL(head);
		removeDuplicates(head);
		System.out.println();
		printLL(head);
	}

}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

/**
 * Brute Force Approach
 * 
 * private static void removeDuplicates(Node head) { Node temp = head; while
 * (temp != null && temp.next != null) { Node curr = temp; while (curr.next !=
 * null) {
 * 
 * if (temp.data == curr.next.data) { Node tt = curr.next; curr.next =
 * curr.next.next; tt.next = null; tt=null; } else { curr = curr.next; } } temp
 * = temp.next; } }
 */
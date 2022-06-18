package websites.leetcode.problems;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4 -> 8) Output: 7 -> 0 -> 8
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int quot = 0;
		ListNode head = null;
		ListNode tempNode = head;
		while (l1 != null && l2 != null) {
			int x = l1.val + l2.val + quot;

			if (x / 10 > 0) {
				quot = x / 10;
				x %= 10;
			}
			tempNode = insertNode(tempNode, x);
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode remNode = l1 != null ? l1 : l2;

		while (remNode != null) {
			int temp = remNode.val + quot;
			quot = 0;
			tempNode = insertNode(head, temp);
			remNode = remNode.next;
		}

		return tempNode;
	}

	private static ListNode insertNode(ListNode head, int x) {

		if (head == null) {
			head = new ListNode(x);
		} else {
			ListNode tempNode = head;

			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = new ListNode(x);
		}
		return head;
	}

	private static void printNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}

	public static void main(String[] args) {

		ListNode num1 = new ListNode(2);
		num1.next = new ListNode(4);
		num1.next.next = new ListNode(3);

		ListNode num2 = new ListNode(5);
		num2.next = new ListNode(6);
		num2.next.next = new ListNode(4);
		num2.next.next.next = new ListNode(8);

		printNode(addTwoNumbers(num1, num2));

	}
}
/**
 * private static ListNode getNode(int i) {
 * 
 * ListNode head = null, temp = null;
 * 
 * while (i > 0) 
 * { 
 * if (temp == null) 
 * { 
 *  temp = new ListNode(i % 10);
 *  head = temp;
 * } else 
 * { 
 * 	temp.next = new ListNode(i % 10); 
 * } i /= 10; 
 * 
 * } return head; }
 * 
 * private static ListNode reverseNode(ListNode l2) {
 * 
 * ListNode newHead = null; ListNode temp = l2; while (temp != null) { ListNode
 * nextNode = temp.next; temp.next = newHead; newHead = temp; temp = nextNode; }
 * 
 * return newHead; }
 * 
 * private static int getNum(ListNode l2) { String num = ""; while (l2 != null)
 * { num += l2.val % 10; l2 = l2.next; } return Integer.valueOf(num); }
 */
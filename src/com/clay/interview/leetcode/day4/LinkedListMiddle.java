package interview.leetcode.day4;

import algods.linkedlist.ListNode;

/**
 * 876. Middle of the Linked List
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class LinkedListMiddle {

    public static void main(String[] args) {
//        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(middleNode(list2).data);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast == null ? slow : slow.next;
    }
}

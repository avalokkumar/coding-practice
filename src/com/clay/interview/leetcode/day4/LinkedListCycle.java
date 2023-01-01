package interview.leetcode.day4;

import algods.binarytree.TreeNode;
import algods.linkedlist.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9, list1.next.next.next);

        System.out.println(detectCycle2(list1).data);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            return slow;
        }

        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode slow2 = head;

                while (slow != slow2) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
}

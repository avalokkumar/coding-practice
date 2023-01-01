package datastructures.linkedlist;

import java.util.List;

/**
 *  141. Linked List Cycle
 *
 *  There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 *  Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(23);
        head.next = new ListNode(25);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(41);        //loop

        head.next.next.next.next = new ListNode(55);
        head.next.next.next.next.next = head.next.next.next;
        boolean hasCycle = hasCycle(head);
        System.out.println(hasCycle);
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

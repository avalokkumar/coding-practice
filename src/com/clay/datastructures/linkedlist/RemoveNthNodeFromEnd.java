package datastructures.linkedlist;

import websites.linkedlist.Node;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(23);
        head1.next = new ListNode(25);
        head1.next.next = new ListNode(33);
        head1.next.next.next = new ListNode(41);
        head1.next.next.next.next = new ListNode(55);

        ListNode result = removeNthFromEnd(head1, 2);
        ListNode.printList(result);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n-- > 0) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }
}



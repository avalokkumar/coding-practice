package datastructures.linkedlist;

import websites.linkedlist.Node;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 */
public class ReorderList {

    public static void main(String[] args) {
        Node head1 = new Node(24);
        head1.next = new Node(25);
        head1.next.next = new Node(33);
        head1.next.next.next = new Node(41);
        head1.next.next.next.next = new Node(55);
//        head1.next.next.next.next.next = new Node(45);
        //24 25 33 41 55
        //24 55 25 41 33
        Node reorderedList = reorderList(head1);
        Node.printLL(reorderedList);
    }

    public static Node reorderList(Node head) {
//        24 25 33 41 55
//        24 25 33 55 41
//        24 -> 55 -> 25 -> 41 -> 33
        //24 25 33 41 55 45
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        Node prev = null;
        slow.next = null;
        while (second != null) {
            Node temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        second = prev;
        Node first = head;

        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

        return head;
    }

}

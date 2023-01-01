package datastructures.linkedlist;

import websites.linkedlist.Node;

public class MergeLinkedList {

    public static void main(String[] args) {

        Node head1 = new Node(14);
        head1.next = new Node(23);
        head1.next.next = new Node(33);
        head1.next.next.next = new Node(41);
        head1.next.next.next.next = new Node(55);

        Node head2 = new Node(11);
        head2.next = new Node(21);
        head2.next.next = new Node(26);
        head2.next.next.next = new Node(29);
        head2.next.next.next.next = new Node(35);
        Node mergedNode = mergeLL(head1, head2);
        Node.printLL(mergedNode);

    }

    private static Node mergeLL(Node head1, Node head2) {
        Node mergedNode = new Node(0);
        Node head = mergedNode;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                mergedNode.next = head1;
                head1 = head1.next;
            } else {
                mergedNode.next = head2;
                head2 = head2.next;
            }
            mergedNode = mergedNode.next;
        }

        if (head1 != null) {
            mergedNode.next = head1;
        }
        if (head2 != null) {
            mergedNode.next = head2;
        }
        return head.next;
    }
}

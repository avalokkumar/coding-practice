package algods.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode first = new ListNode(11);
        first.next = new ListNode(29);
        first.next.next = new ListNode(23);
        first.next.next.next = new ListNode(81);
        first.next.next.next.next = new ListNode(199);

//        Node reversedLL = reverse(first);
        ListNode reversedLL = reverseRec(first);
        printList(reversedLL);
    }

    private static void printList(ListNode result) {
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
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











   /* //iterative
    private static Node reverse12(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    //
    private static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
*/

}

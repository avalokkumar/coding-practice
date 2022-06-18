package algods.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {

        Node first = new Node(11);
        first.next = new Node(29);
        first.next.next = new Node(23);
        first.next.next.next = new Node(81);
        first.next.next.next.next = new Node(199);

//        Node reversedLL = reverse(first);
        Node reversedLL = reverseRec(first);
        printList(reversedLL);
    }

    private static void printList(Node result) {
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }


    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static Node reverseRec(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node ll = reverseRec(head.next);
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

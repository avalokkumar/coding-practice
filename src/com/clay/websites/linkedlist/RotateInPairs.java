package websites.linkedlist;

/**
 * Problem - Rotate the linked list in pairs
 * I/P - 11,29,23,81,15,6
 *
 * O/P - 29,11,81,23,6,15,
 */
public class RotateInPairs {

    public static void main(String[] args) {

        Node head = new Node(11);
        head.next = new Node(29);
        head.next.next = new Node(23);
        head.next.next.next = new Node(81);
        head.next.next.next.next = new Node(15);
        head.next.next.next.next.next = new Node(6);
//        head.next.next.next.next.next.next = new Node(53);

        printLL(head);
        rotateInPairs(head);
        printLL(head);
    }

    /**
     *  * I/P - 11,29,23,81,15,6
     *  *
     *  * O/P - 29,11,81,23,6,15,
     * @param head
     * @return
     */
    private static Node rotateInPairs(Node head) {
        Node temp = head.next;

        while (head != null && head.next !=null) {
            Node t = head.next;
            head.next = t.next;
            t.next = head;
            head = t;
            head = head.next.next;
        }
        return temp;
    }

    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println("\n");
    }
}

package algods.linkedlist;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        Node head = new Node(11);
        head.next = new Node(29);
        head.next.next = new Node(23);
        head.next.next.next = new Node(81);
        head.next.next.next.next = new Node(15);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(53);
        printLL(head);
        System.out.println();
        removeNthNodeFromEnd(head, 5);
        printLL(head);
    }


    private static Node removeNthNodeFromEnd(Node head, int pos) {

        if (head == null || head.next == null){
            return head;
        }

        Node curr = head;
        Node temp = head;
        int c = 0;

        while (c++ < pos){
            curr = curr.next;
        }

        while (curr.next != null){
            curr = curr.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

package linkedlist;

//Reverse a given linked list
public class ReverseLinkedList {

    public static void main(String[] args) {

        //Create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node reversedNode = reverseLLRec(head);
        Node.printNode(reversedNode);
    }

    private static Node reverseLL(Node head) {
        Node prev=null;
        Node current=head, next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static Node reverseLLRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node ll = reverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return ll;
    }
}


package algods.linkedlist;

public class LinkedListCycle {
    /*
     * s s s s f f 11 29 23 81 15 6 53 44 29
     */
    public static void main(String[] args) {
        Node head = new Node(11);
        head.next = new Node(29);
        head.next.next = new Node(23);
        head.next.next.next = new Node(81);
        head.next.next.next.next = new Node(15);
        //head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(53);
        head.next.next.next.next.next.next.next = head.next.next.next.next;
        //head.next.next.next.next.next.next.next.next = new Node(29);

        System.out.println(findLinkedListCycle(head));

    }


    private static boolean findLinkedListCycle(Node head) {

        if (head == null){
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null && slow.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

class Node1{

    Node next;
    int data;

    Node1(int data){
        this.data = data;
    }

}

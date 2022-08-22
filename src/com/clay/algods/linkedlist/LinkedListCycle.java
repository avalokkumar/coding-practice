package algods.linkedlist;

public class LinkedListCycle {
    /*
     * s s s s f f 11 29 23 81 15 6 53 44 29
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(29);
        head.next.next = new ListNode(23);
        head.next.next.next = new ListNode(81);
        head.next.next.next.next = new ListNode(15);
        //head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(53);
        head.next.next.next.next.next.next.next = head.next.next.next.next;
        //head.next.next.next.next.next.next.next.next = new Node(29);

        System.out.println(findLinkedListCycle(head));

    }


    private static boolean findLinkedListCycle(ListNode head) {

        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
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

    ListNode next;
    int data;

    Node1(int data){
        this.data = data;
    }

}

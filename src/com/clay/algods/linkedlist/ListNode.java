package algods.linkedlist;

public class ListNode {

    public ListNode next;
    public int data;

    public ListNode(int data){
        this.data = data;
    }

    public ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }

    public static void printLinkedList(ListNode head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

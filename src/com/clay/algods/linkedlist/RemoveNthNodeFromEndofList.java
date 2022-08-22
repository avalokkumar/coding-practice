package algods.linkedlist;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(29);
        head.next.next = new ListNode(23);
        head.next.next.next = new ListNode(81);
        head.next.next.next.next = new ListNode(15);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(53);
        printLL(head);
        System.out.println();
        removeNthNodeFromEnd(head, 5);
        printLL(head);
    }


    private static ListNode removeNthNodeFromEnd(ListNode head, int pos) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode temp = head;
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

    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

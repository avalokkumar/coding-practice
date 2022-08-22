package algods.linkedlist;

public class MergeSortLinkedList {

    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(11);
        first.next = new ListNode(29);
        first.next.next = new ListNode(23);
        first.next.next.next = new ListNode(81);
        first.next.next.next.next = new ListNode(56);
        first.next.next.next.next.next = new ListNode(19);
        first.next.next.next.next.next.next = new ListNode(78);
        printLL(first);
        mergeSort(first);
        System.out.println();
        printLL(first);
    }

    private static void mergeSort(ListNode first) {




    }

}

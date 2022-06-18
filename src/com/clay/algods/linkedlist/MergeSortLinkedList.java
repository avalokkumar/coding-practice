package algods.linkedlist;

public class MergeSortLinkedList {

    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node first = new Node(11);
        first.next = new Node(29);
        first.next.next = new Node(23);
        first.next.next.next = new Node(81);
        first.next.next.next.next = new Node(56);
        first.next.next.next.next.next = new Node(19);
        first.next.next.next.next.next.next = new Node(78);
        printLL(first);
        mergeSort(first);
        System.out.println();
        printLL(first);
    }

    private static void mergeSort(Node first) {




    }

}

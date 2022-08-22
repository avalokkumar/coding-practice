package algods.linkedlist;

import java.util.Scanner;

public class SinglyLinkedList {
    private static ListNode head;
    private static final Scanner s1 = new Scanner(System.in);

    private static void addNodeFront() {
        if(null == head){
            head = new ListNode(s1.nextInt());
        }else{
            ListNode temp = new ListNode(s1.nextInt());
            temp.next = head;
            head = temp;
        }
    }

    private static void addNodeEnd() {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(s1.nextInt());
    }

    //1 6 3 8 4 5
    private static void addNodeInPosition(int pos) {
        ListNode temp = head;
        if (null == head || pos <= 0) {
            return;
        } else if (pos == 1) {
            addNodeFront();
        }

        int c = 0;
        while (c != pos - 2) {
            temp = temp.next;
            c++;
        }
        ListNode node = temp.next;
        temp.next = new ListNode(s1.nextInt());
        temp.next.next = node;
    }

    private static void deleteNodeFront() {
        head = head.next;
    }

    private static void deleteNodeEnd() {
        if (head == null) {
            System.out.println("Nothing to delete");
        }

        ListNode temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    //pos 2
    //4 5 2 9 7 8
    private static void deleteNodeFromPosition(int pos) {
        if (null == head || pos <= 0) {
            return;
        } else if (pos == 1) {
            deleteNodeFront();
        }

        ListNode temp = head;
        int c = 0;

        while (c != pos - 2) {
            temp = temp.next;
            c++;
        }

        temp.next = temp.next.next;

    }

    private static void displayNode() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static void displayLinkedList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {


        System.out.println("Enter\n1 to add node in front\n2 to add node in end\n3 to add node in position\n4 to " +
                "remove node front\n5 remove node from end\n6 to remove from position\n7 display the node\n8 to exit");


        int pos;
        while (true) {
            int ch = s1.nextInt();
            switch (ch) {
                case 1:
                    addNodeFront();
                    break;
                case 2:
                    addNodeEnd();
                    break;
                case 3:
                    System.out.println("Enter the position");
                    pos = s1.nextInt();
                    addNodeInPosition(pos);
                    break;
                case 4:
                    deleteNodeFront();
                    break;
                case 5:
                    deleteNodeEnd();
                    break;
                case 6:
                    System.out.println("Enter the position");
                    pos = s1.nextInt();
                    deleteNodeFromPosition(pos);
                    break;
                case 7:
                    displayNode();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

}

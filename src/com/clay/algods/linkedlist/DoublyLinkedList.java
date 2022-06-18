package algods.linkedlist;

import java.util.Scanner;

public class DoublyLinkedList {

    private static DNode head;
    private static final Scanner s1 = new Scanner(System.in);

    private static void addNodeFront() {
        if (null == head) {
            head = new DNode(s1.nextInt());
            head.prev = head.next = null;
        } else {
            DNode temp = new DNode(s1.nextInt());
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
    }

    private static void addNodeEnd() {
        DNode dNnode = head;
        while (dNnode.next != null) {
            dNnode = dNnode.next;
        }
        DNode temp = new DNode(s1.nextInt());
        temp.prev = dNnode;
        dNnode.next = temp;
    }

    //1 - 6 - 3 - 8 - 4 - 5
    private static void addNodeInPosition(int pos) {
        DNode temp = head;
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
        DNode nextDNode = temp.next;
        //Insert node here
        DNode node = new DNode(s1.nextInt());
        node.prev = temp;
        temp.next = node;
        if (nextDNode != null) {
            nextDNode.prev = node;
        }
        node.next = nextDNode;
    }

    private static void deleteNodeFront() {
        head = head.next;
        head.prev = null;
    }

    private static void deleteNodeEnd() {
        if (head == null) {
            System.out.println("Nothing to delete");
            return;
        } else if (head.next == null) {
            head = null;
            return;
        }

        DNode temp = head;
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

        DNode temp = head;
        int c = 0;

        while (c != pos - 2) {
            temp = temp.next;
            c++;
        }
        temp.next.prev = null;
        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    private static void displayNode() {
        DNode temp = head;
        while (temp != null) {
            System.out.print("[" + temp.prev + " | " + temp.data + " | " + temp.next+ "]\n");
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

package linkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    public static void printNode(Node head) {
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}




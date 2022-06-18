package algods.linkedlist;

public class IntersectionofTwoLinkedLists {

    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    /*
     * s s s s f f 11 29 23 81 15 6 53 44 29
     */
    public static void main(String[] args) {
        Node first = new Node(11);
        first.next = new Node(29);
        first.next.next = new Node(23);
        first.next.next.next = new Node(81);

        Node second = new Node(77);
        second.next = new Node(15);
        second.next.next = new Node(83);
        first.next.next.next.next = second.next.next;
        second.next.next.next = new Node(53);
        second.next.next.next.next = new Node(78);
        printLL(first);
        printLL(second);

        Node intPoint = findIntersection(first, second);
        System.out.println();
        System.out.println(intPoint != null ? intPoint.data : null);
    }

    public IntersectionofTwoLinkedLists() {
    }

    private static Node findIntersection(Node x, Node y) {
        int sizeX = size(x);
        int sizeY = size(y);
        int nodeSizeDiff = sizeX < sizeY ? sizeY-sizeX : sizeX-sizeY;

        Node tempX, tempY;
        tempX = x;
        tempY = y;

        while (--nodeSizeDiff >= 0) {
            if(size(x) > size(y)){
                tempX = tempX.next;
            }else if(size(x) < size(y)){
                tempY = tempY.next;
            }
        }

        while (tempX != null && tempY != null) {
            if (tempX == tempY) {
                return tempX;
            }
            tempX = tempX.next;
            tempY = tempY.next;
        }
        return null;
    }

    private static Node findIntersection2(Node x, Node y) {

        if (x == null || y == null) {
            return null;
        }

        Node xHead = x;
        Node yHead = y;

        while (xHead != yHead){
            xHead = xHead;
        }
        return null;
    }

    private static int size(Node n) {
        int counter = 0;
        while (n != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }
}

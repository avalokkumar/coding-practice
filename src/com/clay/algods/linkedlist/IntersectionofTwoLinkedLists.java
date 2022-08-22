package algods.linkedlist;

public class IntersectionofTwoLinkedLists {

    private static void printLL(ListNode head) {
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
        ListNode first = new ListNode(11);
        first.next = new ListNode(29);
        first.next.next = new ListNode(23);
        first.next.next.next = new ListNode(81);

        ListNode second = new ListNode(77);
        second.next = new ListNode(15);
        second.next.next = new ListNode(83);
        first.next.next.next.next = second.next.next;
        second.next.next.next = new ListNode(53);
        second.next.next.next.next = new ListNode(78);
        printLL(first);
        printLL(second);

        ListNode intPoint = findIntersection(first, second);
        System.out.println();
        System.out.println(intPoint != null ? intPoint.data : null);
    }

    public IntersectionofTwoLinkedLists() {
    }

    private static ListNode findIntersection(ListNode x, ListNode y) {
        int sizeX = size(x);
        int sizeY = size(y);
        int nodeSizeDiff = sizeX < sizeY ? sizeY-sizeX : sizeX-sizeY;

        ListNode tempX, tempY;
        tempX = x;
        tempY = y;

        while (--nodeSizeDiff >= 0) {
            if(sizeX > sizeY){
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

    private static ListNode findIntersection2(ListNode x, ListNode y) {

        if (x == null || y == null) {
            return null;
        }

        ListNode xHead = x;
        ListNode yHead = y;

        while (xHead != yHead){
            xHead = xHead;
        }
        return null;
    }

    private static int size(ListNode n) {
        int counter = 0;
        while (n != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }
}

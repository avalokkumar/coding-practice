package linkedlist;

/**
 *     * This can be recursively and iteratively. Iterative solution: find size of both lists and move pointer
 * Find intersection node of two linked lists.
 *     * of longer lists until it reaches the node whose length is the same as shorter list.
 *     * Then move both pointers forward one at a time until they reach the same value. if found return it
 *     * else there is no intersection point. Time Complexity is O(N)
 */
public class Demo8 {

    /*
     * 11 29 23 81 15 6 53 44 29
     */
    public static void main(String[] args) {
        Node first = new Node(11);
        first.next = new Node(29);
        first.next.next = new Node(23);
        first.next.next.next = new Node(81); //
        Node second = new Node(77);
        second.next = new Node(15);
        second.next.next = first.next.next.next;
        second.next.next.next = new Node(53);
        second.next.next.next.next = new Node(78);
        // head.next.next.next.next.next.next.next = new Node(29);
        System.out.println(isIntersected(first, second));
    }

    private static boolean isIntersected(Node x, Node y) {
        int xLength = getLength(x);
        int yLength = getLength(y);
        int lengthDiff =  xLength > yLength ? xLength - yLength : yLength - xLength;

        while (lengthDiff > 0) {
            if (xLength > yLength) {
                x = x.next;
            } else {
                y = y.next;
            }

            lengthDiff--;
        }

        while (x != null) {
            if (x == y) {
                return true;
            }
            x = x.next;
            y = y.next;
        }

        return false;
    }

//    private static void printLL(Node head) {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//    }

    private static int getLength(Node head) {
        int i=0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }
}

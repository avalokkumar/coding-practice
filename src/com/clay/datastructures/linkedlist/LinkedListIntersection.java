package linkedlist;

//Find the Joining point in two linked list
public class LinkedListIntersection {

    public static void main(String[] args) {

        //Create two linked lists
        Node list1 = new Node(1);

        list1.next = new Node(3);
        list1.next.next = new Node(4);

        list1.next.next.next = new Node(5);
        list1.next.next.next.next = new Node(6);
        list1.next.next.next.next.next = new Node(9);

        Node list2 = new Node(2);
        list2.next = new Node(7);
        list2.next.next = list1.next.next.next;

        //Find the intersection
        System.out.println("Intersection node: " + findIntersection(list1, list2).data);
    }

    private static Node findIntersection(Node list1, Node list2) {
        int size1 = Node.getLength(list1);
        int size2 = Node.getLength(list2);

        if (size1 > size2) {
            list1 = shiftNode(list1, size1 - size2);
        } else {
            list2 = shiftNode(list2, size2 - size1);
        }

        while (list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }

    private static Node shiftNode(Node list, int diff) {
        while (diff > 0) {
            list = list.next;
            diff--;
        }
        return list;
    }

    // find intersection of two linked lists
    public static Node findIntersection1(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }
}

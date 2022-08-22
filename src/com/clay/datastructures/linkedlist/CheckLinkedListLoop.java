package linkedlist;

//Check loop within a linked list

public class CheckLinkedListLoop {
    public static void main(String[] args) {

        // Create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = head.next.next.next;

        Node loopingNode = checkLoop(head);
//        Node.printNode(head);
        System.out.println(loopingNode.data);
    }

    private static Node checkLoop(Node head) {

        Node slow = head;
        Node fast = head;
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if (hasLoop) {
            while (head != slow) {
                slow = slow.next;
                head = head.next.next;
                if (head == slow) {
                    return head;
                }
            }
        }

        return slow;
    }
}

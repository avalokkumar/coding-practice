package algods.linkedlist;

public class MergeKSortedList {


    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node mergeKLists(Node[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        if (nodes.length == 1) {
            return nodes[0];
        }
        return sort(nodes, 0, nodes.length - 1);
    }

    private static Node sort(Node[] nodes, int low, int high) {
        if(low >= high){
            return nodes[low];
        }
        int mid = (low + high) / 2;
        Node leftNode = sort(nodes, low, mid);
        Node rightNode = sort(nodes, mid + 1, high);
        return merge(leftNode, rightNode);
    }

    private static Node merge(Node leftNode, Node rightNode) {

        Node helper = new Node(0);
        Node tempNode = helper;

        while (leftNode != null || rightNode != null) {

            if (leftNode == null) {
                tempNode.next = rightNode;
                rightNode = rightNode.next;

            } else if (rightNode == null) {
                tempNode.next = leftNode;
                leftNode = leftNode.next;
            } else {

                if (leftNode.data <= rightNode.data) {
                    tempNode.next = leftNode;
                    leftNode = leftNode.next;
                }else {
                    tempNode.next = rightNode;
                    rightNode = rightNode.next;
                }
            }
            tempNode = tempNode.next;
        }

        return helper.next;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, 1);
        Node first = new Node(11);
        first.next = new Node(29);
        first.next.next = new Node(33);
        first.next.next.next = new Node(81);

        Node second = new Node(16);
        second.next = new Node(39);
        second.next.next = new Node(78);

        Node third = new Node(8);
        third.next = new Node(22);
        third.next.next = new Node(35);

        printLL(first);
        printLL(second);
        printLL(third);
        Node mergedList = mergeKLists(new Node[]{first, second, third});
        printLL(mergedList);
    }

}

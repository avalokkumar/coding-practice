package algods.linkedlist;

public class MergeKSortedList {


    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode mergeKLists(ListNode[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        if (nodes.length == 1) {
            return nodes[0];
        }
        return sort(nodes, 0, nodes.length - 1);
    }

    private static ListNode sort(ListNode[] nodes, int low, int high) {
        if(low >= high){
            return nodes[low];
        }
        int mid = (low + high) / 2;
        ListNode leftNode = sort(nodes, low, mid);
        ListNode rightNode = sort(nodes, mid + 1, high);
        return merge(leftNode, rightNode);
    }

    private static ListNode merge(ListNode leftNode, ListNode rightNode) {

        ListNode helper = new ListNode(0);
        ListNode tempNode = helper;

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
        ListNode first = new ListNode(11);
        first.next = new ListNode(29);
        first.next.next = new ListNode(33);
        first.next.next.next = new ListNode(81);

        ListNode second = new ListNode(16);
        second.next = new ListNode(39);
        second.next.next = new ListNode(78);

        ListNode third = new ListNode(8);
        third.next = new ListNode(22);
        third.next.next = new ListNode(35);

        printLL(first);
        printLL(second);
        printLL(third);
        ListNode mergedList = mergeKLists(new ListNode[]{first, second, third});
        printLL(mergedList);
    }

}

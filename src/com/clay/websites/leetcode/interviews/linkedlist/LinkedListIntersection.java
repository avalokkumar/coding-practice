package websites.leetcode.interviews.linkedlist;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 */
public class LinkedListIntersection {

    public static void main(String[] args) {
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = new ListNode(5);

        ListNode listB = new ListNode(4);
        listB.next = new ListNode(1);
        listB.next.next = listA.next.next;

        ListNode intersectionNode = getIntersection(listA, listB);
        System.out.println(intersectionNode.val);
    }

    private static ListNode getIntersection(ListNode headA, ListNode headB) {

        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        if (sizeA >= sizeB) {
            shiftNode(headA, sizeA - sizeB);
        } else {
            shiftNode(headB, sizeB - sizeA);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                headA.next = null;
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static void shiftNode(ListNode listNode, int diff) {
        while (diff-- > 0) {
            listNode = listNode.next;
        }
    }

    private static int getSize(ListNode node) {
        ListNode tempNode = node;
        int i = 0;
        while (tempNode != null) {
            i++;
            tempNode = tempNode.next;
        }
        return i;
    }
}

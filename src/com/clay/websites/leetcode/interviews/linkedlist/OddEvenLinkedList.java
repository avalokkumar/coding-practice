package websites.leetcode.interviews.linkedlist;

import algods.linkedlist.ListNode;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * <p>
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(12, new ListNode(17, new ListNode(44))))));

        ListNode result = getMergedNode(head);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    //1, 3
    //2,1,3,5,6,4,7
    //1,2,3,5,6,4,7
    //
    private static ListNode getMergedNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}

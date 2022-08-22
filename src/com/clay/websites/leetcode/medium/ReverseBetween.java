package websites.leetcode.medium;

import algods.linkedlist.ListNode;

import java.util.List;

/**
 * 92. Reverse Linked List II
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, null)))));
//        ListNode listNode = new ListNode(5, null);
        ListNode result = reverseBetween(listNode, 2, 4);

        ListNode.printLinkedList(result);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(0, head);
        int count = 0;
        ListNode curr = tempHead;
        while (curr != null) {
            count++;

            if (count == left) {
                ListNode begin = curr;
                ListNode end = curr.next;
                curr = curr.next;

                ListNode prev = null;

                while (curr != null && count++ <= right) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                end.next = curr;
                begin.next = prev;
                break;
            }
            curr = curr.next;
        }

        return tempHead.next;
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode leftEnd = head;
        ListNode rightEnd = head;
        ListNode temp = head;
        ListNode middleNode;

        if (head.next == null) {
            return head;
        }

        for (int i = 1; i < left - 1; i++) {
            leftEnd.next = temp.next;
            leftEnd = leftEnd.next;
            temp = temp.next;
        }

        if (left < 2) {
            middleNode = head;
        } else {
            middleNode = temp.next;
        }

        for (int i = 0; i < right; i++) {
            rightEnd = rightEnd.next;
        }
        ListNode tempMiddle = middleNode;

        for (int i = 0; i < (right - left); i++) {
            tempMiddle = tempMiddle.next;
        }
        tempMiddle.next = null;

        ListNode reversedNode = reverseNode(middleNode);
        leftEnd.next = reversedNode;

        while (reversedNode.next != null) {
            reversedNode = reversedNode.next;
        }
        reversedNode.next = rightEnd;

        return head;
    }


    private static ListNode reverseNode(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

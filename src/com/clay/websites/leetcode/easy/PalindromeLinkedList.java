package websites.leetcode.easy;

import algods.linkedlist.ListNode;

import java.util.List;

/**
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * 1 -> 2 -> 2 -> 1
 *
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
//[1,0,3,4,0,1]
//        ListNode listNode = new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(2))));
        ListNode listNode = new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(4, new ListNode(0, new ListNode(1, null))))));

        System.out.println(isPalindrome(listNode));
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;

        ListNode reversedNode = reverse(slow);

        while (reversedNode != null) {
            if (reversedNode.data != fast.data) {
                return false;
            }
            fast = fast.next;
            reversedNode = reversedNode.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev =  current;
            current = temp;
        }

        return prev;
    }

}

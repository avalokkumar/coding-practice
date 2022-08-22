package websites.leetcode.interviews.linkedlist;

/**
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode node2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode outputNode = addValues(node1, node2);

        while (outputNode != null) {
            System.out.print(outputNode.val + " ");
            outputNode = outputNode.next;
        }
    }

    private static ListNode addValues(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val = carry;

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (val > 9) {
                carry = val / 10;
                val = val % 10;
            } else {
                carry = 0;
            }

            if (result == null) {
                result = new ListNode(val);
            } else {
                ListNode tempNode = result;
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = new ListNode(val);
            }
        }
        return result;
    }
}
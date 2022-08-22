import websites.linkedlist.Node;

/**
 * * Example 1:
 * *
 * * Input: nums = [4,5,6,7,0,1,2], target = 0
 * * Output: 4
 * * Example 2:
 * *
 * * Input: nums = [4,5,6,7,0,1,2], target = 3
 * * Output: -1
 * * Example 3:
 * *
 * * Input: nums = [1], target = 0
 * * Output: -1
 */
public class Demo {

    public static void main(String[] args) {
        Node head = new Node(11);
        head.next = new Node(29);
        head.next.next = new Node(23);
        head.next.next.next = new Node(81);

        Node.printLL(head);
        System.out.println("");
        Node.printLL(reverseLL(head));
    }

    private static Node reverseLL(Node head) {

        Node prev = null;
        Node cur = head, temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    /*private static boolean search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }*/

}

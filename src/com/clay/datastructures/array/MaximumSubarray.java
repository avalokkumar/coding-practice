package array;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums = new int[]{-4, -3, -2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int currMax = 1;
        int currMin = 1;
        int res = Integer.MIN_VALUE;
        for (int val: nums) {
            if (val > res) {
                res = val;
            }
        }

        for (int num : nums) {
            if (num == 0) {
                currMax = 1;
                currMin = 1;
                continue;
            }

            int temp = currMax * num;
            currMax = Math.max(currMax * num, Math.max(currMin * num, num));
            currMin = Math.min(temp, Math.min(currMin * num, num));

            res = Math.max(currMax, res);
        }

        return res;
    }
}

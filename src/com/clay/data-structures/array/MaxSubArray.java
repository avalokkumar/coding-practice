package array;

// https://leetcode.com/problems/maximum-subarray/

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaxSubArray {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -4, 2, -1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            max = Math.max(maxSoFar, max);
        }
        return max;
    }
}

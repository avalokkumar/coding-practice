package websites.leetcode.medium;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeClosestSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
//        int[] nums = new int[]{-4, -1, 1, 2}; //-3 || closestSum = Math.min(closestSum, totSum)
//        int[] nums = new int[]{1, 2, 1, 4, 3};
        //int[] nums = new int[]{1, 1, 2, 3, 4};    //target - 3
        //closestval = 1+4+1 - 3 = 3 // this should be minimum
        // if closestval > 0 | high --
        //else closestval < 0 | low ++

        int result = getClosestSum(nums, 1);
        System.out.println(result);
    }

    private static int getClosestSum(int[] nums, int target) {

        int sum;
        int low;
        int high;
        int result = nums[0]+nums[1]+nums[nums.length-1];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;

            if (i == 0 || nums[i] != nums[i - 1]) {
                while (low < high) {
                    sum = nums[low] + nums[high] + nums[i];
                    if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }

                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}

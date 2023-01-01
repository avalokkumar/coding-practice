package datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2};
        int[] nums = new int[]{2, 7, 9, 3, 1};
//        int[] nums = new int[]{1, 2, 3, 1};
//        int[] nums = new int[]{1, 3, 1};

        System.out.println(rob(nums));
    }

    //p1 = 0
    //p2 = 0
    //loop - 0 to n-1
    //set tmp = p1
    //p1 = max(p2+curr, p1)
    //p2 = tmp

    //2, 7, 9, 3, 1 - p1 - 0, p2 = 0
    //2, 7, 9, 3, 1 - p1 - 0, p2 = 0
    //2, 7, 9, 3, 1 - p1 - 2, p2 = 0
    //2, 7, 9, 3, 1 - p1 - 7, p2 = 2
    //2, 7, 9, 3, 1 - p1 - 7, p2 = 2 - t = 7
    //2, 7, 9, 3, 1 - p1 - 11, p2 = 7, t = 11
    //2, 7, 9, 3, 1 - p1 - 11, p2 = 11, t =  11
    //2, 7, 9, 3, 1 - p1 - 12, p2 = 11, t =  11

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static int rob2(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return maxSum(nums, nums.length - 1, memo);
    }

    private static int maxSum(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }

        memo[i] = Math.max(maxSum(nums, i - 2, memo) + nums[i], maxSum(nums, i - 1, memo));
        return memo[i];
    }

}

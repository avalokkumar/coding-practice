package array;

import java.util.Arrays;

/**
 * 209. Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class MinSizeSubArray {

    public static void main(String[] args) {
//        int[] coins = new int[]{2, 3, 1, 2, 4, 3};
        int[] coins = new int[]{1,4,4};
//        System.out.println(minCoins(coins, 7));
        System.out.println(minCoins(coins, 1));
    }

    public static int minCoins(int[] coins, int value) {
        int[] dp = new int[value + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= value; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[value];
    }
}

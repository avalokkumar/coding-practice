package datastructures.dynamicprogramming;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without
 * changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
            int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }

    //initialize LIS  with defult value as 1
    //loop through from n to 0
    //loop from j = n+1 to arr len
    // if arr[i] < arr[j]
        //  LIS[i] = math.max(LIS[i], 1+LIS[j]);

    //return max of LIS
}

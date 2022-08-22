package websites.leetcode.interviews.linkedlist;

/**
 *   Increasing Triplet Subsequence
 *   Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 *   such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
//        int[] values = new int[]{2,1,5,0,4,6};
        int[] values = new int[]{20,100,10,12,5,13};
        boolean isExist = isTripletExist(values);
        System.out.println(isExist);
    }

    //1,2,3,4,5
    //2,1,5,0,4,6
    //20,100,10,12,5,13

    private static boolean isTripletExist(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int iMax = Integer.MAX_VALUE;
        int jMax = Integer.MAX_VALUE;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] <= iMax) {
                iMax = nums[i];
            } else if (nums[i] <= jMax) {
                jMax = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}

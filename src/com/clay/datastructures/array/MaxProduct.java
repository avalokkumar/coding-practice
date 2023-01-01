package datastructures.array;

/**
 * 1464. Maximum Product of Two Elements in an Array
 * <p>
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * Example 2:
 * <p>
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * Example 3:
 * <p>
 * Input: nums = [3,7]
 * Output: 12
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] input = new int[]{3, 4, 5, 2};

        System.out.println(maxProduct(input));
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int nextMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                nextMax = max;
                max = nums[i];
            } else if (nums[i] > nextMax) {
                nextMax = nums[i];
            }
        }
        return (max - 1) * (nextMax - 1);
    }
}

package websites.leetcode.medium;

/**
 * 238. Product of Array Except Self
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        int[] res = productExceptSelf(nums);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int prefix = 1;
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix *= nums[i];
        }

        return output;
    }
}

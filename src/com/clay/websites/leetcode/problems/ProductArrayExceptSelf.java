package websites.leetcode.problems;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 */
public class ProductArrayExceptSelf {

	private static int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		int mult = 1;

		for (int i=0; i< nums.length; i++) {
			output[i] = mult;
			mult *= nums[i];
		}

		mult = 1;
		for (int j = nums.length-1; j >=0; j--) {
			output[j] = output[j] * mult;
			mult *= nums[j];
		}

		return output;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] result = productExceptSelf(nums);
		for (int r : result)
			System.out.print(r + " ");
	}

}

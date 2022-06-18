package array;

/**
 * author: clay
 * desc:
 * Given an array of integers, find if the array contains any duplicates.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 3};
        System.out.println(containsDuplicate2(nums));
    }

    /*private static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 1) {
                return true;
            }
            count[nums[i]]++;
        }
        return false;
    }*/
//int[] nums = {1, 2, 3, 1};
    //{1, -2, 3, 1}
    //{1, -2, -3, 1}
    private static boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int absValue = Math.abs(nums[i]);
            if (nums[absValue] < 0) {
                return true;
            }
            nums[absValue] = -nums[absValue];
        }
        return false;
    }
}

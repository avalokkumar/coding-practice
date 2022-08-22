package array;

import java.util.HashSet;
import java.util.Set;

/**
 * author: clay
 * desc:
 * Given an array of integers, find if the array contains any duplicates.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4,5,4};
        System.out.println(containsDuplicate3(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
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
    }

    private static boolean containsDuplicate3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> uniqueValues = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueValues.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
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

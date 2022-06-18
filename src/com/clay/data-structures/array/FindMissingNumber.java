package array;

import java.util.ArrayList;
import java.util.List;

//448. Find All Numbers Disappeared in an Array
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        for (int i : findDisappearedNumbers(nums)) {
            System.out.print(i + " ");
        }
    }
    //find the missing number in an array
    //time complexity: O(n)
    //space complexity: O(1)
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

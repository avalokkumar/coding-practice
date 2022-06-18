package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        printNums(threeSum.threeSum(nums));
    }

    private static void printNums(List<List<Integer>> threeSum) {
        for (List<Integer> list : threeSum) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) { // i is the first element
            if (i > 0 && (nums[i] != nums[i - 1])) { // check if the current number is the same as the previous number
                int low = i + 1, high = nums.length - 1; // low and high are the second and third element
                int sum = -nums[i]; // sum is the target

                while (low < high) { // low and high are the second and third element
                    if (nums[low] + nums[high] == sum) { // if the sum is equal to the target
                        result.add(Arrays.asList(nums[i], nums[low], nums[high])); // add the result to the result list
                        while (nums[low] == nums[low + 1]) low++; // if the second element is the same, skip it
                        while (nums[high] == nums[high - 1]) high--; // if the third element is the same, skip it
                        low++;  // move the low pointer to the next element
                        high--; // move the high pointer to the previous element
                    } else if (nums[low] + nums[high] > sum) { // if the sum is greater than the target
                        high--;
                    } else if (nums[low] + nums[high] < sum) { // if the sum is less than the target
                        low++;
                    }
                }
            }
        }
        return result;
    }
    /*public List<List<Integer>> threeSum(int[] nums) {

        int i=0,j,k;
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        while(i < nums.length-2) {
            j = i+1;
            k = nums.length-1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
            }
            i++;
        }
        return result;
    }*/

    //method to return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0

}

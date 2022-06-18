package websites.leetcode.problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> output = getThreeSum(nums);
        System.out.println(output);
    }

    private static List<List<Integer>> getThreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i< nums.length-2; i++) {
            int start = i+1, end = nums.length-1;
            int sum = -nums[i];

            while (start < end) {
                if (nums[start] + nums[end] == sum) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    triplet.add(Math.abs(sum));
                    output.add(triplet);
                    break;
                }else if (nums[start] + nums[end] < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return output;
    }
}

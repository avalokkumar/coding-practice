package datastructures.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 3, 2}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(result, new ArrayList<>(), nums);

        return result;
    }

    private static void permuteRec(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                permuteRec(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

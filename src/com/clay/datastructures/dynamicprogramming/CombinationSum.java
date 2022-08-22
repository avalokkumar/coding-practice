package datastructures.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
 * where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the
 * chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * <p>
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        System.out.println(combinationSum2(candidates, 8));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void dfs(int i, List<List<Integer>> result, ArrayList<Integer> current, int[] nums, int total, int target) {

        if (total == target) {
            result.add(new ArrayList<>(current));
        }

        if (i > nums.length || total > target) {
            return;
        }

        current.add(nums[i]);
        dfs(i, result, current, nums, total + nums[i], target);
        current.remove(current.size() - 1);
        dfs(i+1, result, current, nums, total, target);
    }


    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}




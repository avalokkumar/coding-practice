package datastructures.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        for (List<Integer> vals : combinationSum(candidates, 7)) {
            System.out.println(vals);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (candidates.length == 0) {
            return Collections.emptyList();
        }

        dfs(candidates, current, result, target, 0);

        return result;
    }

    private static void dfs(int[] candidates, List<Integer> current, List<List<Integer>> result, int target, int i) {

        if (target == 0) {
            result.add(new ArrayList<>(current));

        } else if (i >= candidates.length || target < 0) {
            return;
        } else {
            current.add(candidates[i]);
            dfs(candidates, current, result, target - candidates[i], i);

            current.remove(current.size() - 1);
            dfs(candidates, current, result, target, i + 1);
        }
    }

}

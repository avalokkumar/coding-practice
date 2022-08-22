package websites.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 347. Top K Frequent Elements
 *Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] output = topKFrequent(nums, 1);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> freq = new PriorityQueue<>((v1, v2) -> v2[1]-v1[1]);

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            freq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];

        for (int i=0; i< k; i++) {
            res[i] = Objects.requireNonNull(freq.poll())[0];
        }

        return res;
    }
}

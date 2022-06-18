package websites.leetcode.arrays;

//Given an array of integers and an integer k, find out whether there are two distinct indices i and
//j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {

    public static void main(String args[]) {

        //int[] values = {1, 2, 9, 7, 9};
        //int[] values = {99, 99};
        int[] values = {1, 2, 3, 1, 2, 3};
        int k = 2;

        boolean duplicates = containsNearByDuplicates(values, k);

        System.out.println(duplicates);
    }

    private static boolean containsNearByDuplicates(int[] nums, int k) {

        Map valueMap = new HashMap();
        int currentValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            /*if (valueMap.containsKey(currentValue) && valueMap.get(i) <= k) {
                return true;
            }else{
                valueMap.put(i, nums[i]);
            }*/

        }
        return false;
    }
}

/**
 * Brute Force Solution
 *
 * private static boolean containsNearByDuplicates(int[] nums, int k) {
 *
 * for (int i = 0; i < nums.length; i++) {
 * for (int j = i+1; j < nums.length; j++) {
 * if (nums[i] == nums[j] && j - i == k) {
 * return true;
 * }
 * }
 * }
 * return false;
 * }
 **/
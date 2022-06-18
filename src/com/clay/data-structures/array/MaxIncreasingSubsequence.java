package array;

import java.util.List;

//10,9,2,5,3,7,101,18

/**
 * Find the maximum increasing subsequence of a given array of integers.
 * author: clay
 */
public class MaxIncreasingSubsequence {
    public static void main(String[] args) {
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        for (Integer i : longestIncreasingSubsequence(array)) {
            System.out.println(i);
        }

    }

    /* private static List<Integer> maxIncreasingSubsequence(int[] array) {
         int[] dp = new int[array.length];
         int[] prev = new int[array.length];
         int max = Integer.MIN_VALUE;
         int maxIndex = -1;
         for (int i = 0; i < array.length; i++) {
             dp[i] = 1;
             prev[i] = -1;
             for (int j = 0; j < i; j++) {
                 if (array[i] > array[j] && dp[i] < dp[j] + 1) {
                     dp[i] = dp[j] + 1;
                     prev[i] = j;
                 }
             }
             if (dp[i] > max) {
                 max = dp[i];
                 maxIndex = i;
             }
         }
         List<Integer> result = new java.util.ArrayList<>();
         while (maxIndex != -1) {
             result.add(array[maxIndex]);
             maxIndex = prev[maxIndex];
         }
         return result;
     }
     */
    //Find longest increasing subsequence
    public static int[] longestIncreasingSubsequence(int[] array) {
        int[] dp = new int[array.length];
        int[] prev = new int[array.length];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        int[] result = new int[max];
        int i = maxIndex;
        int j = max - 1;
        while (i != -1) {
            result[j--] = array[i];
            i = prev[i];
        }
        return result;
    }

    private static List<Integer> maxIncreasingSubsequence2(int[] array) {
        int[][] dp = new int[array.length][array.length];
        int[] pos = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            pos[i] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] >= array[i]) {
                    pos[i] = pos[j] + 1;
                }

            }
        }

        return null;
    }
}

//
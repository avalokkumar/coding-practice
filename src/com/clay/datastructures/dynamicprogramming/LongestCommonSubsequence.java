package datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

//        System.out.println(longestCommonSubsequence("abc", "def"));
        System.out.println(longestCommonSubsequence("psnw", "vozsh"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int maxCommonSubsequence = 0;
        int i = 0, j = 0;

        while (i < text1.length() && j < text2.length()) {
            if (text1.charAt(i) == text2.charAt(j)) {
                maxCommonSubsequence++;
                i++;
                j++;
            } else {
                if (text1.length() > text2.length()) {
                    i++;
                } else {
                    j++;
                }

            }
        }

        return maxCommonSubsequence;
    }
}

package datastructures.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak {

    public static void main(String[] args) {
//        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
//        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));
//        System.out.println(wordBreak("ab", Arrays.asList("a","b")));
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;

        for (int i = s.length()-1; i >= 0; i--) {
            for (String word : wordDict) {
                if ((i + word.length()) <= s.length() && s.startsWith(word, i)) {
                    dp[i] = dp[i+word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        int j = 0;
        while (j < s.length()) {
            String begStr = s.substring(0, j + 1);
            if (wordDict.contains(begStr)) {
                s = s.substring(begStr.length());
                j = 0;
            } else {
                j++;
            }
        }
        return s.length() == 0;
    }
}

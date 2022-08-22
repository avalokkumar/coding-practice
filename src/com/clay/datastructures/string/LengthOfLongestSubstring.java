package datastructures.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(i));
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}

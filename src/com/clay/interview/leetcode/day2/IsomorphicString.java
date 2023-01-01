package interview.leetcode.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicString {

    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));

        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }
    //f - 4
    //o - 15


    //e -> a || cache mapping - e - a | a - e
    public static boolean isIsomorphic(String s, String t) {
       Map<Character, Character> charMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                if (charMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (charMap.containsValue(t.charAt(i))) {
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int sPos = s.charAt(i) - 'a';
            int tPos = t.charAt(i) - 'a';

            if (sCount[sPos] != tCount[tPos]) {
                return false;
            }
            sCount[sPos]++;
            tCount[tPos]++;

        }

        return true;
    }
}

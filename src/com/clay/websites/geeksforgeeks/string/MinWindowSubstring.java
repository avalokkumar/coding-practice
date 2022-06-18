package websites.geeksforgeeks.string;

/**
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 */
public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    //https://leetcode.com/problems/minimum-window-substring/

    //method to find Minimum Window Substring
    public static String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int[] tCount = new int[256];
        int[] sCount = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        int start = 0, end = 0, minStart = 0, minEnd = 0, count = 0;
        while (end < s.length()) {
            if (tCount[s.charAt(end)] > 0) {
                sCount[s.charAt(end)]++;
                if (sCount[s.charAt(end)] <= tCount[s.charAt(end)]) {
                    count++;
                }
            }
            end++;
            while (count == t.length()) {
                if (end - start < minEnd - minStart) {
                    minStart = start;
                    minEnd = end;
                }
                if (tCount[s.charAt(start)] > 0) {
                    sCount[s.charAt(start)]--;
                    if (sCount[s.charAt(start)] < tCount[s.charAt(start)]) {
                        count--;
                    }
                }
                start++;
            }
        }
        return minEnd == 0 ? "" : s.substring(minStart, minEnd);
    }

    /*private static String minWindow(String s, String t) {
        int[] tCount = new int[256];
        int[] sCount = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        int start = 0, end = 0, minStart = 0, minEnd = 0, minLen = Integer.MAX_VALUE;
        int count = 0;
        while (end < s.length()) {
            if (tCount[s.charAt(end)] > 0) {
                sCount[s.charAt(end)]++;
                if (sCount[s.charAt(end)] <= tCount[s.charAt(end)]) {
                    count++;
                }
            }
            end++;
            while (count == t.length()) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                    minEnd = end;
                }
                if (tCount[s.charAt(start)] > 0) {
                    sCount[s.charAt(start)]--;
                    if (sCount[s.charAt(start)] < tCount[s.charAt(start)]) {
                        count--;
                    }
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);
    }*/
}

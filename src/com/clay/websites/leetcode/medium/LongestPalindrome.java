package websites.leetcode.medium;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = checkSubStrPalindrome(s, i, i);
            int len2 = checkSubStrPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len-1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end+1);
    }

    public static int checkSubStrPalindrome(String s, int i, int j) {
        if (s == null || i > j) {
            return 0;
        }

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));
    }
}


   //Program to return the length of the longest palindrome that can be built with those letters given a string s which consists of lowercase or uppercase letters
   /* public static int longestPalindrome1(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0) {
                res += count[i];
            } else {
                res += count[i] - 1;
            }
        }
        if (res < s.length()) {
            res++;
        }
        return res;
    }*/

package websites.geeksforgeeks.string;

//Regular Expression Matching

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegexMatch {

    public static void main(String[] args) {
        String s = "aacccb";
        String p = "c*a*b*";
        System.out.println(isMatchDP(s, p));
    }

   /* public static boolean isMatch(String s, String p) {
        if (p.equals("")) {
            return s.equals("");
        }
        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        if (p.equals(".*")) {
            return true;
        }
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }
        }
        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        }
        if (p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
        }
        return false;
    }*/
    //Method to match regex with . and * for a given string
    //Time complexity O(n^2)
    //Space complexity O(1)
    ///explain the below solution
   /* public static boolean isMatchDP(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }*/
    public static boolean isMatchDP(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

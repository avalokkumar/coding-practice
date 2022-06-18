package websites.leetcode.problems;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] values = new String[]{"cated", "caterer", "cater"};
        String longestPrefix = findLongestPrefix(values);
        System.out.println(longestPrefix);
    }

    private static String findLongestPrefix(String[] strs) {
        int minSize = Integer.MAX_VALUE;
        String minStr = strs[0];
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            if (str.length() < minSize) {
                minSize = str.length();
                minStr = str;
            }
        }

        for (int i = 0; i < minSize; i++) {
            for (String s: strs) {
                if (s.charAt(i) != minStr.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(minStr.charAt(i));
        }
        return minStr;
    }
}

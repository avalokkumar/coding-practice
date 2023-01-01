package datastructures.string;

/**
 * Write a function to find the longest common prefix in an array of strings.
 * strs = ["flower","flow","flight"]
 * output： "fl"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: The input does not have a common prefix.
 */
public class LongestCommonPrefixOptimized {

    public static void main(String[] args) {
//       String[] inputStrs = {"flower", "flow", "flight"};
//        String[] inputStrs = {"dog","racecar","car"};
        String[] inputStrs = {"geeksforgeeks", "geeks", "geek", "geezer"};

        System.out.println(longestCommonPrefixOptimized(inputStrs, 0, inputStrs.length-1));
//        System.out.println(longestCommonPrefix(inputStrs));
    }

    private static String longestCommonPrefixOptimized(String[] inputStrs, int low, int high) {
        if (low == high) {
            return inputStrs[low];
        }

        if (low < high) {
            int mid = low + (high-low)/2;

            String first = longestCommonPrefixOptimized(inputStrs, 0, mid);
            String second = longestCommonPrefixOptimized(inputStrs, mid+1, high);

            return commonPrefix(first, second);
        }

        return "";
    }

    private static String commonPrefix(String first, String second) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j=0; i < first.length() && j< second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                break;
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();
    }

    /*private static String longestCommonPrefix(String[] inputStrs) {
        int minLen = Integer.MAX_VALUE;
        String minStr = null;
        for (String str : inputStrs) {
            if (minLen > str.length()) {
                minLen = str.length();
                minStr = str;
            }
        }
        for (int i = 0; i < minLen; i++) {
            for (String str: inputStrs) {
                if (str.charAt(i) != minStr.charAt(i)) {
                    return "";
                }
            }
        }
        return minStr;
    }*/
}

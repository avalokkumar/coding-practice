package string;

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
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] inputStrs = {"flower", "flow", "flight"};
        String[] inputStrs2 = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix2(inputStrs2));
    }

    private static String longestCommonPrefix(String[] inputStrs) {
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
    }

    public static String  longestCommonPrefix2 ( String []  strs ) {
        int  n;
        if  ((n  =  strs . length)  ==  0 )  return  " " ;
        for  ( int  i  =  0 ; i  <  strs[ 0 ] . length();  ++ i) {
            for  ( int  j  =  1 ; j  <  n;  ++ j) {
                if  (strs[j] . length()  <=  i  ||  strs[j] . charAt(i)  !=  strs[ 0 ] . charAt(i)) {
                    return  strs[ 0 ] . substring( 0 , i);
                }
            }
        }
        return  strs[ 0 ];
    }
}

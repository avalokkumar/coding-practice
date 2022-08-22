package datastructures.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Character> charVal = new Stack<>();
        Stack<Integer> indexVal = new Stack<>();
        indexVal.add(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                charVal.push(ch);
                indexVal.push(i);

            } else {
                if (!charVal.empty() && charVal.peek() == '(') {
                    charVal.pop();
                    indexVal.pop();
                    max = Math.max(max, i - indexVal.peek());
                } else {
                    indexVal.add(i);
                }
            }
        }

        return max;
    }

    public static int longestValidParentheses2(String s) {
        Stack<Character> charSet = new Stack<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                charSet.add(s.charAt(i));
            } else {
                if (!charSet.isEmpty()) {
                    charSet.pop();
                    maxLen += 2;
                }
            }
            /*if (charSet.isEmpty()) {
                maxSoFar = Math.max(maxSoFar, maxLen);
            }*/
        }
        while (!charSet.empty()) {
            maxLen -=2;
            charSet.pop();
        }

        return maxLen;
    }
}

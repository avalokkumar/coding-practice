package datastructures.string;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("({[)"));
    }

    public static boolean isValid(String s) {
        Stack<Character> charSet = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charVal = s.charAt(i);
            if ((charVal == ']' || charVal == '}' || charVal == ')') && charSet.isEmpty()) {
                return false;

            } else {
                if (!charSet.isEmpty()) {
                    if (charSet.peek() == '[' && charVal == ']') {
                        charSet.pop();

                    } else if (charSet.peek() == '(' && charVal == ')') {
                        charSet.pop();

                    } else if (charSet.peek() == '{' && charVal == '}') {
                        charSet.pop();
                    } else {
                        charSet.add(charVal);
                    }
                } else {
                    charSet.add(charVal);
                }
            }
        }
        return charSet.isEmpty();
    }
}

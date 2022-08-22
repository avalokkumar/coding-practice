package websites.leetcode.easy;

import java.util.List;
import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String s = "abbaca";
//        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i< s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();

        while (!stack.empty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }

  /*  public static String removeDuplicates(String s) {

        int[] charValues = new int[26];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i=0; i< s.length(); i++) {
            charValues[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i< charValues.length; i++) {
            char pos = (char) charValues[s.charAt(index++)];
            if (charValues[i]%2 == 1) {
                sb.append((char) ('a'+ i));
            }
        }

        return sb.toString();
    }*/
}

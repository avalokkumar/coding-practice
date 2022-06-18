package websites.hackerrank;

import java.util.Stack;

public class Demo {
	static char[][] TOKENS = { { '(', ')' }, { '{', '}' }, { '[', ']' } };
	static Stack<Character> stack = new Stack<>();

	private static boolean isBalanced(String sample) {

		for (char ch : sample.toCharArray()) {
			if (isOpenBracket(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatch(char top, char ch) {
		for (char[] token : TOKENS) {
			if (top == token[0]) {
				return ch == token[1];
			}
		}
		return false;
	}

	private static boolean isOpenBracket(char ch) {
		for (char[] token : TOKENS) {
			if (ch == token[0]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		String sample = "({{([])}[]})";

		System.out.println(isBalanced(sample));
	}
}

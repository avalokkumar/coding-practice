package random;

import java.util.Stack;

public class Demo2 {

	public static void main(String[] args) {
		String s1 = "Hello World";

		System.out.println(reverseStr(s1));
	}

	private static String reverseStr(String s1) {

		Stack<Character> stack = new Stack<>();
		char[] reversedStr = new char[s1.length()];
		int j = 0;
		for (int i = 0; i < s1.length(); i++) {
			stack.push(s1.charAt(i));
		}
		while (!stack.empty()) {
			reversedStr[j++] = stack.pop();
		}
		return String.valueOf(reversedStr);
	}
}

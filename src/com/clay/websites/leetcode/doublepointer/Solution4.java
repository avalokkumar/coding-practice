package websites.leetcode.doublepointer;

import java.util.Scanner;

/**
 * 680. Valid Palindrome II (Easy) Description of the topic: You can delete a
 * character to determine whether it can form a palindrome string. 
 * Input: "abca"
 * or abcdcfba Output: True
 */
public class Solution4 {

	private static final Scanner scanner = new Scanner(System.in);

	private static boolean validPalindrome(String str) {
		char[] strChars = str.toCharArray();
		int i = 0, j = str.length() - 1;

		while (i++ <= j--) {
			if (strChars[i] != strChars[j]) {
				return isPalindrome(strChars, i, j - 1) || isPalindrome(strChars, i + 1, j);
			}
		}

		return true;
	}

	private static boolean isPalindrome(char[] strChars, int i, int j) {
		while (i++ < j--) {
			if (strChars[i] != strChars[j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = scanner.nextLine();

		System.out.println(validPalindrome(str));

	}

	//Program to convert decimal to binary
	private int decimalToBinary(int num) {
		return -1;
	}

}

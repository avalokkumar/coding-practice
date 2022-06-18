package websites.leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 *
 */
public class Solution3 {

	private static final Scanner scanner = new Scanner(System.in);

	private static String reverseVowels(String str) {
		int i = 0, j = str.length() - 1;
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		char[] result = new char[str.length()];

		while (i <= j) {
			char chI = str.charAt(i);
			char chJ = str.charAt(j);

			if (!vowels.contains(chI)) {
				result[i++] = chI;
			} else if (!vowels.contains(chJ)) {
				result[j--] = chJ;
			} else {
				result[i++] = chJ;
				result[j--] = chI;
			}
		}
		return new String(result);
	}

	public static void main(String[] args) {

		String str = scanner.nextLine();

		System.out.println(reverseVowels(str));
	}

}

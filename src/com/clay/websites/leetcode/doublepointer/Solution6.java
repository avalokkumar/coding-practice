package websites.leetcode.doublepointer;

import java.util.Scanner;

/**
 * Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: "apple"
 *
 * Delete some characters in s so that it forms a string in the string list d
 * and find the longest string that can be constructed. If there are multiple
 * results of the same length, return the smallest string of the lexicographical
 * order.
 */
public class Solution6 {

	private static final Scanner scanner = new Scanner(System.in);

	private static String findLongestWord(String s, String[] d) {

		String longestStr = "";
		int i = 0, j = 0;
		for (String subStr : d) {

			while (j < subStr.length() && i < s.length()) {
				if (s.charAt(i) == subStr.charAt(j)) {
					j++;
					i++;
				} else {
					i++;
				}
			}

			if (j == subStr.length() && (subStr.length() > longestStr.length()
					|| (subStr.length() == longestStr.length() && longestStr.compareTo(subStr) > 0))) {
				longestStr = subStr;
			}
			i = j = 0;
		}

		return longestStr;
	}

	public static void main(String[] args) {

		String s = scanner.nextLine();
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] d = new String[n];

		for (int i = 0; i < n; i++) {
			d[i] = scanner.nextLine();
		}

		System.out.println(findLongestWord(s, d));

	}
}

//compare each string in d with s

//if match, store index in d in other temp arr
//if new match with more length string, store and replace old in temp arr
// if more match with same length, store it in temp arr new index
//	if single value in temp return it else sort it lexicographically and return first element


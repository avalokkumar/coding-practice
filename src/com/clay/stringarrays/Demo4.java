package stringarrays;
/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero edits) away.
 *
 * Note: second string is the edit version of string 1
 */
public class Demo4 {

	private static boolean checkEdit(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}

		// add
		if (s1.length() == s2.length() - 1) {
			// check all char in s1 should be in s2
			return checkChars(s1, s2);

		}
		// remove
		else if (s1.length() - 1 == s2.length()) {
			// check all char in s2 should be in s1
			return checkChars(s2, s1);

		}
		// replace
		else if (s1.length() == s2.length()) {
			return checkReplace(s1, s2);
		}

		return false;
	}

	private static boolean checkReplace(String str1, String str2) {
		int c = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (!str2.contains(String.valueOf(str1.charAt(i))) && c > 1) {
				return false;
			}else {
				c++;
			}
		}
		return true;
	}

	private static boolean checkChars(String str1, String str2) {
		boolean hasAllChar = true;
		for (int i = 0; i < str1.length(); i++) {
			if (!str2.contains(String.valueOf(str1.charAt(i)))) {
				hasAllChar = false;
				break;
			}
		}
		return hasAllChar;
	}

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "ple";
		System.out.println(checkEdit(s1, s2));

		s1 = "pales";
		s2 = "pale";
		System.out.println(checkEdit(s1, s2));

		s1 = "pale";
		s2 = "bale";
		System.out.println(checkEdit(s1, s2));

		s1 = "pale";
		s2 = "bake";
		System.out.println(checkEdit(s1, s2));
	}

}

/**
 * insert-
 */

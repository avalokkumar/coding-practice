package stringarrays;

/**
 * Given a string, write a function to check if it is a permutation of a palin-
 * drome. A palindrome is a word or phrase that is the same forwards and
 * backwards. A permutation is a rearrangement of letters.The palindrome does
 * not need to be limited to just dictionary words.
 *
 * Ex:
 */
public class Demo3 {

	private static boolean isPalindromePermutation(String str) {

		String trimmedStr = str.replace(" ", "");
		int len = trimmedStr.length();
		int c = 1;
		boolean isEventLen = (len % 2 == 0) ? true : false;

		int[] charCounts = getCharCount(trimmedStr.toLowerCase());

		for (int i = 0; i < charCounts.length; i++) {
			if (isEventLen && charCounts[i] % 2 != 0) {
				return false;
			}

			if (!isEventLen && charCounts[i] % 2 != 0) {
				if (c > 1) {
					return false;
				} else {
					c++;
				}
			}
		}
		return true;
	}

	private static int[] getCharCount(String str) {

		int[] charCounts = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int offset = (int) 'a';
			int index = ch - offset;
			charCounts[index]++;

		}
		return charCounts;
	}

	public static void main(String[] args) {

		String str = "Tact Cal";
		System.out.println(isPalindromePermutation(str));
	}
}

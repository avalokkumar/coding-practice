package random;

/**
 * Find the smallest window in a string containing all characters of another
 * string
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		String s1 = "this is a test string";
		String s2 = "tist";
		if (s2.length() > s1.length()) {
			System.out.println("no such window can exist");
		}
		System.out.println(checkMinWindow(s1, s2));

	}

	private static String checkMinWindow(String s1, String s2) {
		int minLen = 0;
		int s2Size = s2.length();
		String minWindow;

		for (int i = 0; i < s1.length(); i++) {
			for (int j = i + s2Size; j < s1.length(); j++) {

				// check minWndow length
				minLen = hasWindow(s1.substring(i, j), s2) ? j : 0;
				minWindow = s1.substring(i, j);
			}
		}

		return null;
	}

	private static boolean hasWindow(String s1SubStr, String s2) {
		boolean hasSubStr = true;
		for (int i = 0; i < s2.length(); i++) {
			if (!s1SubStr.contains(s2.charAt(i) + "")) {
				hasSubStr = false;
			}
		}
		return hasSubStr;
	}
}

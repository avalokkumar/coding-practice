package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome partition
 *
 */
public class Demo6 {

	public static List<List<String>> partition(String s) {
		List<List<String>> validDecompositions = new ArrayList();
		List<String> decompInProgress = new ArrayList<String>();
		decomposeString(s, 0, decompInProgress, validDecompositions); // Kick off the recursion
		return validDecompositions;
	}

	/*
	 * 1.) Take all palindrome snippets from where we are 2.) Recurse on them 3.)
	 * When base case is hit, we add the answer and backtrack to keep going
	 */
	private static void decomposeString(String s, int buildPointer, List<String> decompInProgress,
			List<List<String>> validDecompositions) {

		if (buildPointer == s.length()) {
			validDecompositions.add(new ArrayList<>(decompInProgress)); // deep copy the list. this is key.
		} else {

			/*
			 * Check ever snippet take from the buildPointer to the end of the string.
			 */
			for (int i = buildPointer; i < s.length(); i++) {

				/*
				 * Only recurse if the snippet we COULD take is a palindrome
				 */
				if (isPalindrome(s, buildPointer, i)) {

					/*
					 * Take the snippet now that we know it will be palindromic. WATCH OUT FOR OFF
					 * BY 1! We add 1 to i for the upper bound since substring() in the Java API
					 * EXCLUDES the right bound.
					 */
					String palindromicSnippet = s.substring(buildPointer, i + 1);

					// Add the snippet to our decomposition that we are working on
					decompInProgress.add(palindromicSnippet);

					// Recurse and advance progress
					decomposeString(s, i + 1, decompInProgress, validDecompositions);

					/*
					 * We are done searching, remove the snippet from our progress. Next loop
					 * iteration continues our progress in this stack frame
					 */
					decompInProgress.remove(decompInProgress.size() - 1);
				}

			}

		}

	}

	/*
	 * Helper. Just checks if the region from low (inclusive) to high (inclusive) is
	 * a palindrome.
	 */
	public static boolean isPalindrome(String s, int low, int high) {

		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String abc = "abcb";
		List<List<String>> part = partition(abc);

		for (List<String> comp : part) {
			for (String str : comp) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}

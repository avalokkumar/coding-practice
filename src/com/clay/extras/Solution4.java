package extras;

import java.util.Scanner;

public class Solution4 {

	static int designerPdfViewer(int[] h, String word) {

		int maxHeight = 0;
		int offset = (int) 'a';
		for (int i = 0; i < word.length(); i++) {
			int charIndex = word.charAt(i) - offset;
			if (h[charIndex] > maxHeight) {
				maxHeight = h[charIndex];
			}
		}

		return maxHeight * word.length();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] h = new int[26];

		for (int i = 0; i < 26; i++) {
			h[i] = scanner.nextInt();
		}

		String word = scanner.next();

		int result = designerPdfViewer(h, word);

		System.out.println(result);

		scanner.close();
	}
}

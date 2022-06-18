package extras;

import java.util.Scanner;

/**
 * Period  Height
	0          1
	1          2
	2          3
	3          6
	4          7
	5          14
 *
 */
public class Solution5 {

	static int utopianTree(int n) {
		int height = 1;

		if (n == 0) {
			return 1;
		}

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				height += 1;
			} else {
				height *= 2;
			}			
		}
		return height;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scanner.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();

			int result = utopianTree(n);
			System.out.println(result);
		}

	}
}

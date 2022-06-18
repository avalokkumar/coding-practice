package extras;

import java.util.Scanner;

/**
 * 2 4 3 -1 -3 4 2 4 2 0 -1 2 1
 *
NO
YES
YES
YES
YES
NO
YES
YES
NO
NO
 */
public class Solution6 {

	static String angryProfessor(int k, int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0) {
				k--;
			}
		}
		return (k > 0) ? "YES" : "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scanner.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {

			int n = scanner.nextInt();

			int k = scanner.nextInt();

			int[] a = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			String result = angryProfessor(k, a);

			System.out.println(result);

		}
		scanner.close();
	}
}

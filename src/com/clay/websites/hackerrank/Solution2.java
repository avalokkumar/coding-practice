package websites.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Electronics Shop
 */

public class Solution2 {

	/*
	 * Complete the getMoneySpent function below.
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {

		int maxSpent = 0;
		int minKeyB = Arrays.stream(keyboards).min().getAsInt();
		int minDrives = Arrays.stream(drives).min().getAsInt();
		int cost = 0;
		if (minKeyB + minDrives > b) {
			return -1;
		}

		for (int i = 0; i < keyboards.length; i++) {
			// maxSpent+=keyboards[i];
			for (int j = 0; j < drives.length; j++) {
				cost = keyboards[i] + drives[j];
				if (cost <= b && cost > maxSpent) {
					maxSpent = cost;
				}
			}
		}
		return maxSpent;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int b = scanner.nextInt();

		int n = scanner.nextInt();

		int m = scanner.nextInt();

		int[] keyboards = new int[n];

		for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
			keyboards[keyboardsItr] = scanner.nextInt();
		}

		int[] drives = new int[m];

		for (int drivesItr = 0; drivesItr < m; drivesItr++) {
			drives[drivesItr] = scanner.nextInt();
		}

		/*
		 * The maximum amount of money she can spend on a keyboard and USB drive, or -1
		 * if she can't purchase both items
		 */

		int moneySpent = getMoneySpent(keyboards, drives, b);
		System.out.println();
		scanner.close();
	}

}

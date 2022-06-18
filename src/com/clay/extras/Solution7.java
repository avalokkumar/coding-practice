package extras;

import java.util.Scanner;

/*
 * 20 23 6\
 * 20 -> 02
 */
public class Solution7 {

	// Complete the beautifulDays function below.
	static int beautifulDays(int i, int j, int k) {

		int c = 0;
		for (int k2 = i; k2 <= j; k2++) {
			int revK2 = reverseNum(k2);

			if ((k2 - revK2) % k == 0) {
				c++;
			}
		}

		return c;
	}

	static int reverseNum(int num) {
		int revNum = 0;
		while (num != 0) {
			revNum *= 10;
			revNum += num % 10;
			num /= 10;
		}

		return revNum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int i = scanner.nextInt();

		int j = scanner.nextInt();

		int k = scanner.nextInt();

		int result = beautifulDays(i, j, k);
		
		System.out.println(result);
		scanner.close();
	}
}

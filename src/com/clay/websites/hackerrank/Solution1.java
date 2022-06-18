package websites.hackerrank;

import java.util.Scanner;

public class Solution1 {

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		long aCount = 0;
		long bCount = 0;
		
		for (int i = 0; i < apples.length; i++) {
			int aDistance = apples[i] + a;
			if (aDistance >= s && aDistance <= t) {
				aCount++;
			}
		}
		
		for (int i = 0; i < oranges.length; i++) {
			int bDistance = oranges[i] + b;
			if (bDistance >= s && bDistance <= t) {
				bCount++;
			}
		}
		
		System.out.println(aCount+"\n"+bCount);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// range - [s,t]
		int s = scanner.nextInt();

		int t = scanner.nextInt();

		int a = scanner.nextInt();

		int b = scanner.nextInt();

		int m = scanner.nextInt();

		int n = scanner.nextInt();

		int[] apples = new int[m];

		for (int i = 0; i < m; i++) {
			apples[i] = scanner.nextInt();
		}

		int[] oranges = new int[n];

		for (int i = 0; i < n; i++) {
			oranges[i] = scanner.nextInt();
		}

		countApplesAndOranges(s, t, a, b, apples, oranges);

		scanner.close();
	}
}

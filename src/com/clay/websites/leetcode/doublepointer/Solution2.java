package websites.leetcode.doublepointer;

import java.util.Scanner;

/*
 * 633. Sum of Square Numbers
 */
public class Solution2 {

	public static boolean judgeSquareSum(int c) {

		int i = 0;
		int sqrSum = 0;
		int sqrt = (int) Math.sqrt(c);

		while (i <= sqrt) {
			sqrSum = i * i + sqrt * sqrt;

			if (sqrSum == c) {
				return true;

			} else if (sqrSum < c) {
				i++;
				
			} else {
				sqrt--;
			}
		}
		return false;
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int number = scanner.nextInt();

		System.out.println(judgeSquareSum(number));
	}
}

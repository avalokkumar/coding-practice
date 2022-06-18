package websites.leetcode.doublepointer;

import java.util.Scanner;

/*
 * Leetcode ：167. Two Sum II - Input array is sorted (Easy)
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
   Output: index1=1, index2=2
 */
public class TwoSum {

	private static final Scanner scanner = new Scanner(System.in);

	private static int[] printSumIndex(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;

		while (i < j) {
			if (numbers[i] + numbers[j] == target) {
				return new int[] {i+1, j+1};
			} else if (numbers[i] + numbers[j] > target) {
				j--;

			} else if (numbers[i] + numbers[j] < target) {
				i++;
			}
		}
		return new int[]{-1, -1};
	}

	public static void main(String[] args) {

		int t = scanner.nextInt();
		int[] numbers = new int[t];
		for (int tItr = 0; tItr < t; tItr++) {
			numbers[tItr] = scanner.nextInt();
		}
		int target = scanner.nextInt();
		int[] vals = printSumIndex(numbers, target);
		System.out.println(vals[0] + " " + vals[1]);
	}

}

package websites.leetcode.doublepointer;

import java.util.Scanner;

/**
 * 88. Merge Sorted Array (Easy)
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 */
public class Solution5 {

	private static final Scanner scanner = new Scanner(System.in);

	private static int[] getSortedArray(int[] mArr, int m, int[] nArr, int n) {
		int i = m - 1;
		int j = n - 1;
		int mergeIndex = m + n - 1;

		while (i >= 0 || j >= 0) {
			if (i < 0) {
				mArr[mergeIndex--] = nArr[j--];
			} else if (j < 0) {
				mArr[mergeIndex--] = mArr[i--];
			} else if (mArr[i] > nArr[j]) {
				mArr[mergeIndex--] = mArr[i--];
			} else {
				mArr[mergeIndex--] = nArr[j--];
			}
		}

		return mArr;

	}

	public static void main(String[] args) {

		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int[] mArr = new int[m + n];
		int[] nArr = new int[n];

		for (int i = 0; i < m; i++) {
			mArr[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			nArr[i] = scanner.nextInt();
		}

		int[] sortedArr = getSortedArray(mArr, m, nArr, n);

		for (int i = 0; i < sortedArr.length; i++) {
			System.out.print(sortedArr[i] + " ");
		}

	}

}

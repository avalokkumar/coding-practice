package algods;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: [4, 6, 7, 7] 
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7],
 * [6, 7, 7], [7,7], [4,7,7]]
 *
 */
public class MaxIncreasingSubsequence {

	private static List<List<Integer>> findMaxSubSeq(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {

		}

		return null;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 7, 7 };

		for (List<Integer> subArr : findMaxSubSeq(arr)) {
			for (int i : subArr) {
				System.out.print(i + " ");
			}
			System.out.println("\n");
		}
		System.out.println();

	}

}

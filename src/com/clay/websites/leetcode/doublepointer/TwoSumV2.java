package websites.leetcode.doublepointer;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode ：167. Two Sum II - Input array is sorted (Easy)
 * 
 * Input: numbers={2, 1, 11, 7, 8, 13, 5, 14}, target=16
   Output: index1=1, index2=2
 */
public class TwoSumV2 {

	private static int[] printSumIndex(int[] numbers, int target) {
		Map<Integer, Integer> sumMap = new HashMap<>();

		for (int i=0; i<numbers.length; i++) {
			int compliment = target - numbers[i];
			if (sumMap.containsKey(compliment)) {
				return new int[]{sumMap.get(compliment), i};
			}
			sumMap.put(numbers[i], i);
		}
		throw new IllegalArgumentException("No match found");
	}

	public static void main(String[] args) {

		int[] numbers = new int[] {2, 1, 11, 7, 8, 13, 5, 14};
		int[] vals = printSumIndex(numbers, 19);
		System.out.println(vals[0] + " " + vals[1]);
	}

}

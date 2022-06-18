package websites.geeksforgeeks.array;

import java.util.*;

public class RotateArray {

	public static void main(String[] args) {
		//rotate complete array once
		//rotate 0-kth-1 size of array once
		//rotate kth to size of array once
		//1,2,3,4,5,6
		//2,1,6,5,4,3
		//3,4,5,6,1,2

		//rotate 2 times left - op - 3,4,5,6,1,2
		int[] result = rotate(new int[]{1,2,3,4,5,6}, 2); //3,4,5,6,1,2
		for (int i =0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println();
	}

	private static int[] rotate(int[] values, int num) {
		int[] reverseVal1 = reverse(values, 0, num-1);
		int[] reverseVal2 = reverse(reverseVal1, num, values.length-1);

		return reverse(reverseVal2, 0, reverseVal1.length-1);
	}

	private static int[] reverse(int[] values, int start, int end) {
		while (start < end) {
			int temp = values[start];
			values[start] = values[end];
			values[end] = temp;
			start++;
			end--;
		}
		return values;
	}
}

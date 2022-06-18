package algods;

import java.util.Arrays;
import java.util.List;

public class KthLargestElementinanArray {

	private static List<Integer> findDuplicates(int[] a) {

		List<Integer> list = Arrays.asList(123,32,323,23);

		for (int i = 0; i < a.length; ++i) {
			
			int index = Math.abs(a[i]) - 1;
			
			if (a[index] < 0)
				list.add(index + 1);
			a[index] *= -1;
		}
		return list;
		// return duplicates;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 5, 23, 6, 4, 6, 16, 14 };

//		for (int i : findDuplicates(arr)) {
//			System.out.println(i);
//		}
		System.out.println(findKthLargest(arr, 3));
	}

	private static int findKthLargest(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[arr.length - k];
	}

	private static int findKthLargest2(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[arr.length - k];
	}
}

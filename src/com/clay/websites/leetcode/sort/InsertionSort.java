package websites.leetcode.sort;

public class InsertionSort {

	private static void sort(int[] a) {

		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1);
				} else {
					break;
				}
			}
		}
	}

	private static void swap(int[] arr, int i) {
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
	}

	public static void main(String[] args) {

		int[] values = new int[] { 12, 31, 44, 11, 9, 3, 18 };

		sort(values);

		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
}

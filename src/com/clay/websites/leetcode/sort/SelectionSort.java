package websites.leetcode.sort;

public class SelectionSort {

	private static void sort(int[] a) {

		for (int i = 1; i < a.length; i++) {

			int j = i;
			int current = a[i];

			while (j > 0 && current < a[j - 1]) {
				a[j] = a[--j];
			}

			a[j] = current;
		}
	}

	public static void main(String[] args) {

		int[] values = new int[] { 12, 31, 44, 11, 9, 3, 18,1 };

		sort(values);

		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}

}

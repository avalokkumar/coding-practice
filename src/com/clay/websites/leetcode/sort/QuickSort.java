package websites.leetcode.sort;

/**
 * Worst-case performance	O(n2)
 * Best-case performance	O(n log n) (simple partition)
 * or O(n) (three-way partition and equal keys)
 * Average performance	O(n log n)
 * Worst-case space complexity	O(n) auxiliary (naive)
 * O(log n) auxiliary
 */
public class QuickSort {

	private static void sort(int[] values, int low, int high) {

		if (low >= high) {
			return;
		}

		int pivot = values[(low + high) / 2];

		int part = partition(values, low, high, pivot);

		sort(values, low, part - 1);
		sort(values, part, high);
	}

	private static int partition(int[] values, int low, int high, int pivot) {

		while (low <= high) {

			while (values[low] < pivot) {
				low++;
			}

			while (values[high] > pivot) {
				high--;
			}

			if (low <= high) {
				swap(values, low, high);
				low++;
				high--;
			}
		}

		return low;
	}

	private static void swap(int[] values, int low, int high) {

		int temp = values[low];
		values[low] = values[high];
		values[high] = temp;

	}

	public static void main(String[] args) {
		int[] values = new int[] { 12, 31, 44, 11, 9, 3, 18 };

		sort(values, 0, values.length - 1);
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}

}

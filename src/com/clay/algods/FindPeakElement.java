package algods;

public class FindPeakElement {

	static int findPeakValue(int arr[], int n) {

		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (mid > 0 && mid < n - 1 && arr[mid - 1] <= arr[mid] && arr[mid + 1] <= arr[mid]) {
				return mid;
			}

			if (low < mid && arr[mid] < arr[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1, 2, 6, 4 };

		System.out.println(findPeakValue(arr, arr.length));
	}

}

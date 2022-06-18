package websites.leetcode.sort;

public class MergeSort {

    private static void sort(int[] a, int low, int high, int[] bucket) {

        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;

        sort(a, low, mid, bucket);
        sort(a, mid + 1, high, bucket);

        merge(a, low, high, bucket);
    }

    private static void merge(int[] arr, int low, int high, int[] bucket) {

        for (int i = low; i <= high; i++) {
            bucket[i] = arr[i];
        }

        int mid = (low + high) / 2;

        int i = low;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (bucket[left] <= bucket[right]) {
                arr[i++] = bucket[left++];
            } else {
                arr[i++] = bucket[right++];

            }
        }

        while (left <= mid) {
            arr[i++] = bucket[left++];
        }

        while (right <= high) {
            arr[i++] = bucket[right++];
        }
        /*System.arraycopy(arr, leftStart, bucket, i, leftEnd - left + 1);
        System.arraycopy(arr, rightStart, bucket, i, rightEnd - right + 1);
        System.arraycopy(arr, leftStart, bucket, leftStart, size);*/

    }

    public static void main(String[] args) {

        int[] values = new int[]{12, 55, 31, 44, 11, 9, 18};
        int[] bucket = new int[values.length];

        sort(values, 0, values.length - 1, bucket);

        for (int i = 0; i < values.length - 1; i++) {
            System.out.println(values[i]);
        }
    }
}
//int[] arr = new int[]{1, 41, 49, 34, 29, 13, 18};
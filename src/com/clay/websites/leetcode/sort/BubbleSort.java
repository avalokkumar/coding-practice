package websites.leetcode.sort;

public class BubbleSort {

    private static void sort(int[] arr) {

        int lastSortedIndex = arr.length - 1;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastSortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    isSorted = false;
                }
            }
            lastSortedIndex--;
        }
    }

    private static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

    public static void main(String[] args) {
        int[] values = new int[]{12, 31, 44, 11, 9, 3, 18};

        sort(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}

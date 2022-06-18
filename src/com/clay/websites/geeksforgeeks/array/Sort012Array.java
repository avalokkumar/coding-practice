package websites.geeksforgeeks.array;

/**
 * Sort an array of 0s, 1s and 2s
 */
public class Sort012Array {
    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
//        int[] arr = {2, 0, 2, 1, 1, 0};
//        int[] arr = {2, 0, 1};
        int[] arr = {1, 2, 1, 0, 2};
//        int[] arr = {2, 0, 1, 1};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high--);
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}

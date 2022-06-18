package websites.geeksforgeeks.array;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 7, 0, 5 };
        int k = 3;
        System.out.println(kthSmallest(arr, 3));
    }

   private static int kthSmallest(int[] arr, int k) {
        return kthSmallest(arr, 0, arr.length - 1, k);
    }

    private static int kthSmallest(int[] arr, int start, int end, int k) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        if (i == k) {
            return arr[i];
        } else if (i < k) {
            return kthSmallest(arr, i + 1, end, k);
        } else {
            return kthSmallest(arr, start, i - 1, k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

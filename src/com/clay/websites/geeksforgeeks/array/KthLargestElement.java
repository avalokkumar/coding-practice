package websites.geeksforgeeks.array;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 7, 0, 5 };
        int k = 3;
        System.out.println(kthLargest(arr, 0));
    }

   private static int kthLargest(int[] arr, int k) {
        return kthLargest(arr, 0, arr.length - 1, k);
    }

    private static int kthLargest(int[] arr, int start, int end, int k) {
        int pivot = arr[start];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] >= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        if (i == k) {
            return arr[i];
        } else if (i < k) {
            return kthLargest(arr, i + 1, end, k);
        } else {
            return kthLargest(arr, start, i - 1, k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

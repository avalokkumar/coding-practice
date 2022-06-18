package algods.example;

public class SortingRevision {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 31, 44, 11, 9, 3, 18};
        int[] bucket = new int[arr.length];
        //selectionSort(arr);
        //bubbleSort(arr);
        //bubbleSortOptimised(arr);
        //insertionSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1, bucket);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int low, int high, int[] bucket) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid, bucket);
        mergeSort(arr, mid + 1, high, bucket);

        merge(arr, low, high, bucket);
    }

    private static void merge(int[] arr, int low, int high, int[] bucket) {
        for (int i = low; i <= high; i++) {
            bucket[i] = arr[i];
        }

        int i = low;
        int mid = (low + high) / 2;
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

    }

    /*private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionValue = partition(arr, low, high);
            quickSort(arr, low, partitionValue - 1);
            quickSort(arr, partitionValue + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pIndex = low;

        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, high);

        return pIndex;
    }*/

   /* private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(arr, minIndex, i);
            }
        }
    }*/

    /*private static void bubbleSortOptimised(int[] arr) {
        int lastIndex = arr.length - 1;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < lastIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            lastIndex--;
        }
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }*/

    /*private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }*/
}

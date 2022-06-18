package array;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(arr, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        rightRotate(arr2, 4);
        System.out.println("");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    private static void rightRotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;
        //1 2 3 4 5 6 7 - rotate 3 [7-3 = 4]
        //4 3 2 1 7 6 5
        //5 6 7, 1 2 3 4
        reverse(arr, 0, len-k-1);
        reverse(arr, len-k, len-1);
        reverse(arr, 0, len-1);
    }

    private static void leftRotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int end = arr.length-1;

        reverse(arr, 0, k-1);
        reverse(arr, k, end);
        reverse(arr, 0, end);
    }


    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

package algods;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    private static int search(int[] arr, int t) {
        int i = 0;
        int j = arr.length;
        int pivot = findPivot(arr);
        int leftArr = Arrays.binarySearch(arr, 0, pivot, t);
        if (leftArr > -1) {
            return leftArr;
        }
        int rightArr = Arrays.binarySearch(arr, pivot, j, t);

        if (rightArr > -1) {
            return rightArr;
        }

        return -1;
    }

    public static int findPivot(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = i + ((j - i) / 2);
            if (i == mid || j == mid) {
                return (nums[i] < nums[mid]) ? i : j;

            }

            if (nums[mid] > nums[j]) {
                i = mid;
            } else if (nums[mid] < nums[j]) {
                j = mid;
            } else {
                return mid;
            }
        }

        return i;
    }


    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;

        System.out.println(search(arr, target));

    }
}

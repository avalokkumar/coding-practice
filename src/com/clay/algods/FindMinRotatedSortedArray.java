package algods;

import static java.lang.Math.min;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 */
public class FindMinRotatedSortedArray {

    public static int findMin(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            int mid = i + ((j - i) / 2);

            if (i == mid || j == mid) {
                return min(nums[i], min(nums[j], nums[mid]));
            }

            if (nums[mid] > nums[j]) {
                i = mid;

            } else if (nums[mid] < nums[j]) {
                j = mid;
            } else {
                return nums[j];
            }
        }
        return nums[j];
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 2, 1, -3};

        System.out.println(findMin(arr));

    }


}


package datastructures.array;

//34. Find First and Last Position of Element in Sorted Array
public class SearchRange {

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};

        int[] res = searchRange(nums, 8);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false);

        return new int[]{l, r};
    }

    private static int binarySearch(int[] nums, int target, boolean isLeftMost) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {

            int m = low + (high - low) / 2;

            if (target < nums[m]) {
                high = m - 1;

            } else if (target > nums[m]) {
                low = m + 1;
            } else {
                index = m;
                if (isLeftMost) {
                    high = m - 1;
                } else {
                    low = m + 1;
                }
            }
        }

        return index;
    }
}

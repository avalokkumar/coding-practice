package array;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 7, 2, 3, 2, 8};
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findPeakElement2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && mid < right && nums[mid] >= nums[mid + 1] && nums[mid] >= nums[mid - 1]) {
                return mid;
            }

            if (mid < right && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
/*
    private static int findHighestPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int maxPeak = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
            maxPeak = Math.max(maxPeak, nums[left]);
        }
        return maxPeak;
    }*/
}

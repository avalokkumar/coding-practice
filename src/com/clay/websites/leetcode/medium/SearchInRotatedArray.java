package websites.leetcode.medium;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }
    // {4, 5, 6, 7, 0, 1, 2}
    //mid -> 7

    // {5, 6, 0, 1, 2, 3,4}
    //


    //method to search the target in the rotated array
    private static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) { //while the low index is less than or equal to the high index
            int mid = low + (high - low) / 2; //find the mid index
            if (nums[mid] == target) {  //if the mid index is equal to the target
                return mid; //return the mid index
            }

            if (nums[low] <= nums[mid]) {   //if the low index is less than or equal to the mid index
                if (target >= nums[low] && target < nums[mid]) {    //if the target is greater than or equal to the low index and less than the mid index
                    high = mid - 1; //set the high index to the mid index minus 1
                } else {
                    low = mid + 1;  //else set the low index to the mid index plus 1
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {   //if the target is greater than the mid index and less than or equal to the high index
                    low = mid + 1;  //set the low index to the mid index plus 1
                } else {
                    high = mid - 1; //else set the high index to the mid index minus 1
                }
            }
        }
        return -1;
    }
}

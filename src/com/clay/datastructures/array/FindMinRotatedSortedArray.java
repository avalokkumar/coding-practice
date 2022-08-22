package array;

public class FindMinRotatedSortedArray {

    public static void main(String[] args) {
//        int[] nums = new int[]{3,4,5,-1, 1,2};
        int[] nums = new int[]{2,1};
        System.out.println(findMin(nums));
    }

    //3,4,5,6,7,1,2,
    public static int findMin(int[] nums) {
        int l =0;
        int r = nums.length-1;
        int min = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
            }

            int mid = (l + r)/2;
            min = Math.min(min, nums[mid]);

            if (nums[mid] >= nums[l]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return min;
    }
}

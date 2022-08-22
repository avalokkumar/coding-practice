package array;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    private static int findKthLargest(int[] nums, int i) {
        return findKthLargest(nums, 0, nums.length - 1, i);
    }

    private static int findKthLargest(int[] nums, int left, int right, int k) {
        int pivot = nums[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (left < j && k <= j) {
            return findKthLargest(nums, left, j, k);
        } else if (i < right && k >= i) {
            return findKthLargest(nums, i, right, k);
        } else {
            return nums[k];
        }
    }

    public static int findKthLargest1(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == k - 1) {
                return nums[index];
            } else if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

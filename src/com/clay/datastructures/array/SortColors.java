package array;

public class SortColors {
    public static void main(String[] args) {
        int[] input = new int[]{2,0,2,1,1,0};

        sortColors(input);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high--);
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}

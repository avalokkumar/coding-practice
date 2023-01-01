package datastructures.recursion;

//4.2 Write a recursive function to count the number of items in a list.
public class SumNums {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 6};
        int sum = getSumOfNumbers(nums, nums.length-1);
//        int sum = getSumOfNumbers(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(sum);
    }

    private static int getSumOfNumbers(int[] nums, int size) {
        if (size == 0) {
            return nums[size];
        } else {
            return nums[size] + getSumOfNumbers(nums, size-1);
        }
    }
}

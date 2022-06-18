package websites.leetcode.medium;

//Write a program to find the next minimum value not in the array. Value should not be 0;

public class FindNextMin {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println(findNextMin(arr));
    }

    private static int findNextMin(int[] arr) {
//        List<Integer> list = arr.
        int start =0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return -1;
    }
}

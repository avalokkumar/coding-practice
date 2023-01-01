package array;

///Find the maximum sum of a subarray with size k
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int k = 3;
        System.out.println(findMaxSum(arr, k));
    }

    private static int findMaxSum(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSumSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSumSoFar = Math.max(currentSumSoFar + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currentSumSoFar);
        }
        return maxSum;
    }
}

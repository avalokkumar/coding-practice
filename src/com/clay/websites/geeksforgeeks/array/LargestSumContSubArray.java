package websites.geeksforgeeks.array;

public class LargestSumContSubArray {

    public static void main(String[] args) {
        int[] val = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maxSubArraySum(val));
    }

    private static int maxSubArraySum(int[] val) {
        int curSum = val[0];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < val.length; i++) {
            curSum = Math.max(val[i], curSum + val[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}

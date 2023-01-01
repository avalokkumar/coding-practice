package datastructures.array;

/**
 * Input: arr[] = {5, 5, 10, 100, 10, 5}
 * Output: 110
 * Explanation: Pick the subsequence {5, 100, 5}.
 * The sum is 110 and no two elements are adjacent. This is the highest possible sum.
 * <p>
 * Input: arr[] = {3, 2, 7, 10}
 * Output: 13
 * Explanation: The subsequence is {3, 10}. This gives sum = 13.
 */
public class MaxSumNoAdjacent {

    public static void main(String[] args) {
//        int[] input = new int[]{5, 5, 10, 100, 10, 5};
        int[] input = new int[]{3, 2, 7, 10};
        System.out.println(maxSum(input));
    }

    public static int maxSum(int[] values) {

        return maxSum(values, 0);
    }

    public static int maxSum(int[] values, int index) {

        if (index >= values.length) {
            return 0;
        }

        if (values[index] < 0) {
            return maxSum(values, index + 1);
        }

        int take = values[index] + maxSum(values, index + 2);
        int skip = maxSum(values, index + 1);

        return Math.max(take, skip);
    }
}

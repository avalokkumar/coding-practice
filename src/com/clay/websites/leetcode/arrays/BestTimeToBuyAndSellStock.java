package websites.leetcode.arrays;

    public class BestTimeToBuyAndSellStock {

    public static void main(String args[]) {
        //int[] sharePrices = {45, 18, 2, 100, 89, 67, 3, 89};
        //int[] sharePrices = {7, 1, 5, 3, 6, 4};
        int[] sharePrices = {7, 6, 4, 3, 1};


        int maxProfit = getMaxProfit(sharePrices);
        System.out.println(maxProfit);
    }

    private static int getMaxProfit(int[] sharePrices) {

        ////Kadane's algorithm
        if (sharePrices.length == 0) {
            return 0;
        }

        int min = sharePrices[0];
        int maxProfit = 0;

        for (int i = 1; i < sharePrices.length; i++) {

            if (sharePrices[i] > min) {
                maxProfit = Math.max(maxProfit, sharePrices[i] - min);
            } else {
                min = sharePrices[i];
            }
        }

        return maxProfit;
    }


}

/**
 * BruteForce approach
 * private static int getMaxProfit(int[] sharePrices) {
 *
 * int maxDiff = -1;
 * int maxDiffSoFar = -1;
 *
 * for (int i = 0; i < sharePrices.length; i++) {
 * for (int j = i + 1; j < sharePrices.length; j++) {
 * if (sharePrices[i] < sharePrices[j]) {
 * maxDiff = Math.max(maxDiff, sharePrices[j] - sharePrices[i]);
 * }
 * }
 * maxDiffSoFar = Math.max(maxDiffSoFar, maxDiff);
 * }
 *
 * return maxDiffSoFar;
 * }
 **/
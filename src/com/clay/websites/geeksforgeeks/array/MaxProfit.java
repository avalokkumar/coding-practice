package websites.geeksforgeeks.array;

/**
 * Maximum profit by buying and selling a share at most twice
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        int profit = maxPrice - minPrice;
        if (profit > maxProfit) {
            maxProfit = profit;
        }
        int maxDiff = maxPrice - minPrice;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        if (maxDiff > maxProfit) {
            maxProfit = maxDiff;
        }
        return maxProfit;
    }
}/*
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }*/

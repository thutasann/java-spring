package KeyPatterns.SlidingWindow.leetcodes.easy;

public class BestTimeToBuyAndSellStock {
    public static void main() {
        System.out.println("\nBest Time to Buy and Sell Stock ==> ");
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Max Profit: " + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}

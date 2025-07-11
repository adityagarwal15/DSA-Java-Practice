public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Track the lowest price so far
        int maxProfit = 0;                // Track the max profit we can make

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update buying price if lower found
            } else {
                // Calculate profit if we sell today
                int profit = prices[i] - minPrice;

                // Update max profit if this is the best so far
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit; // Return best profit
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 6, 4, 3, 1};
        int[] prices2 = {7, 1, 5, 3, 6, 4};

        System.out.println("Max Profit (Test 1): " + maxProfit(prices1)); // 0
        System.out.println("Max Profit (Test 2): " + maxProfit(prices2)); // 5
    }
}

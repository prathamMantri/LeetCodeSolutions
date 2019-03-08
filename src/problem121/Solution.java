package problem121;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */


class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        if (prices.length == 2) {
            return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        }

        int buy = prices[0];
        int sell = prices[1];
        int profit = 0;

        for (int i = 1; i < prices.length - 1; i++) {

            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i + 1];
            }

            if (sell < prices[i + 1]) {
                sell = prices[i + 1];
            }

            if (profit < (sell - buy)) {
                profit = sell - buy;
            }
        }

        return profit;

    }

    public static void main(String args[]) {

        int[] price = {1, 2};

        Solution sol = new Solution();
        sol.maxProfit(price);

    }


}

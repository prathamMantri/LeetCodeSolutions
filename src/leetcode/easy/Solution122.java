package leetcode.easy;

public class Solution122 {
    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int[] prices = {7, 1, 5, 3, 6, 4};
        solution122.maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit = prices[i + 1] - prices[i] + profit;
            }
        }

        return profit;
    }


}

package leetcode.medium;

import java.util.Arrays;

public class Solution322 {
    public static void main(String[] args) {
        Solution322 sol = new Solution322();
        int[] coins = {1, 3, 5};
        sol.coinChange(coins, 11);


    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}

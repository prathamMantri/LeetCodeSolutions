package leetcode.medium;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (S > total || S < -total)
            return 0;

        int[] dp = new int[2 * total + 1];
        dp[0 + total] = 1;

        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * total + 1];
            for (int j = 0; j < 2 * total + 1; j++) {
                if (dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[total + S];
    }
}

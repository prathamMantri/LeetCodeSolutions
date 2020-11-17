package leetcode.medium;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        int index = 0;
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];

        dp[index++] = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < dp[0]) {
                dp[0] = nums[i];
            }
            if (nums[i] > dp[index - 1]) {
                dp[index++] = nums[i];
            }
            int place = findInsertionPoint(dp, -1, index - 1, nums[i]);
            dp[place] = nums[i];
        }
        return index;
    }

    public int findInsertionPoint(int[] dp, int lo, int hi, int key) {
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (dp[mid] >= key)
                hi = mid;
            else
                lo = mid;
        }
        return hi;
    }
}

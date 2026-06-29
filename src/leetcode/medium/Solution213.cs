//https://leetcode.com/problems/house-robber-ii/

public class Solution213 {
    public int Rob(int[] nums) {
        if(nums.Length == 1)
        {
            return nums[0];
        }
        if(nums.Length == 2)
        {
            return Math.Max(nums[0], nums[1]);
        }

        int max1 = robCircle (nums, 0, nums.Length-2);
        int max2 = robCircle (nums, 1, nums.Length-1);

        return Math.Max(max1, max2);
    }

    private int robCircle(int[] nums, int index, int length)
    {
        int len = length - index + 1;
        int[] dp = new int[len + 2];
        for(int i=0; i<len; i++)
        {
            dp[i+2] = Math.Max(dp[i+1], dp[i] + nums[index+i]);
        }
        return dp[len+1];
    }
}

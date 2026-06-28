// https://leetcode.com/problems/house-robber/description/

public class Solution198 {
    public int Rob(int[] nums) {
        if(nums.Length == 1)
        {
            return nums[0];
        }
        if(nums.Length == 2)
        {
            return Math.Max(nums[0], nums[1]);
        }
        nums[1] = Math.Max(nums[1], nums[0]);

        for(int i=2; i< nums.Length;i++)
        {
            nums[i] = Math.Max(nums[i] + nums[i-2], nums[i-1]);
        }

        return nums[nums.Length-1];
    }
}

package leetcode.medium;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {


        if (nums == null || nums.length <= 1)
            return false;


        int[][] dp = new int[nums.length][nums.length];
        dp[0][0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 1; j < nums.length; j++) {
                if (i >= j)
                    continue;
                sum = dp[i][j - 1] + nums[j];
                dp[i][j] = sum;

              /*  if(k==0 && sum == 0){
                    return true;
                }else if(k==0){
                    continue;
                }else if(sum % k == 0)
                    return true;*/
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }

        return false;
    }
}

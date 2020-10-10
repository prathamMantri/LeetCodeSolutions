package leetcode.hard;

public class Solution312 {

    /**
     * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
     * <p>
     * Find the maximum coins you can collect by bursting the balloons wisely.
     * <p>
     * Note:
     * <p>
     * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     * Example:
     * <p>
     * Input: [3,1,5,8]
     * Output: 167
     * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     */

    public int maxCoins(int[] nums) {


        /**
         *
         * The logic is very simple. We are going to use DP and divide the main array into n-1 sub arrays, where n is length of array/
         *
         * if length of array is 4 => [3, 5, 1, 8];
         *
         * subarrays => len 1 => [3]   [5]   [1]   [8]  => calculate the max value after bursting each balloon.
         *              len 2 => [3, 5] [5, 1] [1, 8] => calculate the max value from each sub array, for 3, before is 0 and after is value from above 5 and for 5 after is 0 and before is above calculated 3. Thats how you will get max value
         *              len 3 => [3, 5,  1] [5,  1,  8] => apply same process to 3 with [5, 1] being already burst get the [5, 1] as "after" value from above and "before" as 0
         *              len 4 => [3, 5,  1,  8] => simillarly for 3, before is 0 and after is value from above [5, 1, 8]
         *
         */


        int[][] dp = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {

                    //initially setting leftValue and rightValue to 1 as its goint to multiply current value;
                    int leftValue = 1;
                    int rightValue = 1;

                    // If there is an element on left side or right side, that value will be considered.

                    if (i != 0) {
                        leftValue = nums[i - 1];
                    }
                    if (j != nums.length - 1) {
                        rightValue = nums[j + 1];
                    }
                    // before after are nothing but already calculated values for the particular element if it has to be deleted or not

                    // if k is i then before is 0 else before is T[i][k-1]
                    //if k is j then after is 0 else after is T[k+1][j]
                    int after = 0;
                    int before = 0;

                    if (i != k) {
                        before = dp[i][k - 1];
                    }
                    if (j != k) {
                        after = dp[k + 1][j];
                    }
                    // get the max value between all the calculated value for each k from that length.
                    dp[i][j] = Math.max(before + (leftValue * nums[k] * rightValue) + after, dp[i][j]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + "    ");
            }
            System.out.println();
        }

        return dp[0][nums.length - 1];
    }
}



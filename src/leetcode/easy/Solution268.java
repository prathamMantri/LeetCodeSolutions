package leetcode.easy;

public class Solution268 {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */


    public int missingNumber(int[] nums) {

        int sum = 0;
        int length = nums.length;


        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
        }

        return length * (length + 1) / 2 - sum;

    }


}

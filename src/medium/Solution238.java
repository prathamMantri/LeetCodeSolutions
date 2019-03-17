package medium;

public class Solution238 {
    /*
     *
     * Given an array nums of n integers where n > 1,  return an array output such that output[i]
     * is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *   Input:  [1,2,3,4]
     *   Output: [24,12,8,6]
     *
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity?
     * (The output array does not count as extra space for the purpose of space complexity analysis.)
     *
     */

    public int[] productExceptSelf(int[] nums) {
        /*int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;*/
        int[] res = new int[nums.length];
        int runningPrefix = 1;
        for(int i=0; i<nums.length;i++){
            res[i] = runningPrefix;
            runningPrefix = runningPrefix*nums[i];
        }
        int runningSuffix = 1;
        for(int i=nums.length-1; i>=0; i--){
            res[i]= runningSuffix*res[i];
            runningSuffix = runningSuffix * nums[i];
        }
        return res;
    }

    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        Solution238 solution238 = new Solution238();
        solution238.productExceptSelf(nums);
    }
}

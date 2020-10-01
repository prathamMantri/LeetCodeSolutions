package leetcode.medium;

public class Solution152 {
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = maxSoFar;
        for (int i = 1; i < nums.length; i++) {

            int temp = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));

            maxSoFar = temp;

            max = Math.max(maxSoFar, max);

        }
        return max;
    }
}

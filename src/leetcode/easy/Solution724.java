package leetcode.easy;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        int pivot = -1;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum == nums[0]) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum = leftSum + nums[i - 1];
            int rightSum = sum - nums[i] - leftSum;
            if (leftSum == rightSum)
                return i;
        }
        return pivot;
    }


}

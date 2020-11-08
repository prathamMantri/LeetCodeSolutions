package leetcode.easy;

public class Solution746 {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] += nums[n + i] * 10000;
        }

        //  1,   2,  3,  4,  4,  3,  2,  1
        //
        for (int i = n - 1; i >= 0; i--) {
            nums[2 * i + 1] = nums[i] / 10000;
            nums[2 * i] = nums[i] % 10000;
        }

        return nums;
    }
}

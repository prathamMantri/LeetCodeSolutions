package leetcode.hard;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                found = true;
            }
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (!found) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index == nums.length)
                nums[0] = (-1) * Math.abs(nums[0]);
            else
                nums[index] = (-1) * Math.abs(nums[index]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                return i;
        }
        if (nums[0] > 0) {
            return nums.length;
        }

        return nums.length + 1;
    }
}

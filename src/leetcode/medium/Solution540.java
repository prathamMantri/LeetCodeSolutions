package leetcode.medium;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1)
                mid--;
            if (nums[mid + 1] == nums[mid])
                left = mid + 2;
            else
                right = mid;
        }
        return nums[left];
    }
}

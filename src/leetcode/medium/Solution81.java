package leetcode.medium;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return search(left, right, target, nums);
    }

    private boolean search(int left, int right, int target, int[] nums) {
        if (left > right) return false;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return true;
        if ((nums[mid] <= nums[left] && nums[mid] <= nums[right]) || (nums[mid] >= nums[left] && nums[mid] >= nums[right]))
            return search(left, mid - 1, target, nums) || search(mid + 1, right, target, nums);
        if ((nums[left] <= target && target <= nums[mid]))
            return search(left, mid - 1, target, nums);
        return search(mid + 1, right, target, nums);
    }


}

package leetcode.medium;

/// WRONG do it using three way binary search
public class Solution34 {

    public static void main(String[] args) {
        Solution34 sol = new Solution34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        sol.searchRange(nums, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (end + start) / 2;
        int[] res = {-1, -1};
        while (start < end) {

            if (nums[start] == target) {
                res[0] = start;
                res[1] = start + 1;
                return res;
            }
            if (nums[end] == target) {
                res[0] = end;
                res[1] = end + 1;
                return res;
            }

            if (nums[mid] == target) {
                res[0] = mid;
                res[1] = mid + 1;
                return res;
            } else if (target < nums[mid]) {
                end = mid;
                mid = (end + start) / 2;
            } else {
                start = mid + 1;
                mid = (end + start) / 2;
            }
        }
        return res;
    }

}

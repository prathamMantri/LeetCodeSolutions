package leetcode.hard;

public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right;
        int sum = 0;
        int ans = sum;
        for (int n : nums) {
            sum = sum + n;
            left = Math.max(n, left);
        }
        right = sum;
        if (m == 1) {
            return sum;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, nums, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isPossible(int target, int[] nums, int m) {
        int count = 1;
        int sum = 0;
        for (int n : nums) {
            if (count > m)
                return false;
            if (sum + n > target) {
                count++;
                sum = n;
            } else {
                sum = sum + n;
            }
        }
        return count <= m;
    }
}

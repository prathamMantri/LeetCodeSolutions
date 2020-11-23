package leetcode.medium;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = 0, end = -1;
        // set max as first element
        int max = nums[0];
        // set min as last element
        int min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // keep setting the max by traversing from start
            max = Math.max(max, nums[i]);
            // keep setting the min by traversing from end
            min = Math.min(min, nums[n - 1 - i]);
            // if current element from right is greater than min found till, meaning we found starting point
            if (nums[n - 1 - i] > min) start = n - 1 - i;
            // if current element is from left is less than max found till now, meaning  we found ending point
            if (nums[i] < max) end = i;
        }
        return end - start + 1 > 0 ? end - start + 1 : 0;
    }
}

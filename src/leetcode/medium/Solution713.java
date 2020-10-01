package leetcode.medium;

public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int prod = 1;
        int count = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            prod *= nums[windowEnd];
            while (prod >= k) {
                prod = prod / nums[windowStart];
                windowStart++;
            }

            count = count + windowEnd - windowStart + 1;
        }

        return count;
    }
}

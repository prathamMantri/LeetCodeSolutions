package leetcode.medium;

public class Solution215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Solution215 sol = new Solution215();
        System.out.println(sol.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {

        int max = nums[0];
        int res = max;
        int maxIndex = 0;
        int size = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }

        while (k > 0) {
            for (int i = 0; i < size; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[maxIndex];
                    nums[maxIndex] = temp;
                    maxIndex = i;
                }
            }
            res = max;
            max = Integer.MIN_VALUE;
            size--;
            k--;
        }
        return res;
    }
}

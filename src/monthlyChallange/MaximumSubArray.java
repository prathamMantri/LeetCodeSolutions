package monthlyChallange;

public class MaximumSubArray {
    public static void main(String[] args) {
        MaximumSubArray sol = new MaximumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0], currentMax = nums[0];
        int i = 1;
        while (i < nums.length) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            max = Math.max(currentMax, max);
            i++;
        }
        return max;
    }
}

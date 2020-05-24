package leetcode.medium;

import java.util.Arrays;

public class Solution31 {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2};
        Solution31 sol = new Solution31();
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));


    }

    public void nextPermutation(int[] nums) {

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                i++;
                j++;
            } else {
                swapRequired(i, j, nums);
                i++;
                j++;
            }
        }
    }

    boolean swapRequired(int i, int j, int[] nums) {
        if (nums[i] == nums[j] || nums[j] > nums[i]) {
            return false;
        }
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return swapRequired(i, j, nums);

    }


}

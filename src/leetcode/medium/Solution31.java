package leetcode.medium;

import java.util.Arrays;

public class Solution31 {

    public static void main(String[] args) {

        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        Solution31 sol = new Solution31();
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {

        int index = nums.length - 1;

        while (index >= 0) {
            if (nums[index] > nums[--index])
                break;
        }

        int pos1 = index++;
        int start = index;
        int end = nums.length - 1;

        while (index < nums.length && nums[pos1] < nums[index]) {
            index++;
        }
        int pos2 = index - 1;
        swap(pos1, pos2, nums);
        reverse(start, end, nums);
    }

    private void swap(int pos1, int pos2, int[] nums) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;

    }

    private void reverse(int start, int end, int[] nums) {
        while (start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }


}

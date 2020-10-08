package leetcode.medium;

public class Solution1060 {

    public int missingElement(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] + k;
        }
        int res = nums[0];
        int i = 1;
        while (i < nums.length) {
            while (++res != nums[i]) {
                k--;
                if (k == 0) {
                    return res;
                }
            }
            i++;
        }
        return res + k - 1;
    }

}

package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) return res;

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) res.add(Math.abs(nums[i]));
            else nums[idx] *= -1;
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return res;
    }

}

package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        Integer res1 = null, res2 = null;
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                res[0] = numsMap.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            numsMap.put(nums[i], i);
        }
        return res;
    }
}

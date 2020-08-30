package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetMap.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++)
            twoSum(results, nums, i, -nums[i], targetMap);
        return results;
    }

    public void twoSum(List<List<Integer>> results, int[] nums, int index, int target, Map<Integer, Integer> targetMap) {
        //{-1, 0, 1, 2, -1, -4}
        List<Integer> result;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == index)
                continue;
            if (targetMap.containsValue(target - nums[i])) {
                result = new ArrayList<>();
                result.add(target - nums[i]);
                result.add(nums[i]);
                result.add(-target);
                results.add(result);
            }
        }

        /*List<Integer> result = new ArrayList<>();
        List<Integer> twoSumList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            if (twoSumList.contains(target - nums[i])) {
                result.add(nums[index]);
                result.add(nums[i]);
                result.add(target - nums[i]);
                results.add(result);
                return;
            } else {
                twoSumList.add(nums[i]);
            }
        }*/
    }
}

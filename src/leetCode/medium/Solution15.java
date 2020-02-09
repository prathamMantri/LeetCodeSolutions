package leetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            twoSum(results, nums, i, nums[i]);
        return results;
    }

    public void twoSum(List<List<Integer>> results, int[] nums, int index, int value) {
        List<Integer> result = new ArrayList<>();

        List<Integer> twoSumList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            if (twoSumList.contains(value - nums[i])) {
                result.add(nums[index]);
                result.add(nums[i]);
                result.add(value - nums[i]);
                results.add(result);
                return;
            } else {
                twoSumList.add(nums[i]);
            }
        }
    }
}
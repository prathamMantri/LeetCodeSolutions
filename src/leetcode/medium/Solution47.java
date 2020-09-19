package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return null;
        }
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(results, result, visited, nums);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, boolean[] visited, int[] nums) {

        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            result.add(nums[i]);
            helper(results, result, visited, nums);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
        return;
    }
}

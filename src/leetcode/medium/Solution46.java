package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return null;
        }
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        helper(results, result, visited, nums);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, boolean[] visited, int[] nums) {

        if (result.size() == nums.length) {
            if (!results.contains(result))
                results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result.add(nums[i]);
            helper(results, result, visited, nums);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
        return;
    }
}

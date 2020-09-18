package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    /*
              Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

             The same repeated number may be chosen from candidates unlimited number of times.

             Note:

             All numbers (including target) will be positive integers.
             The solution set must not contain duplicate combinations.
             Example 1:

             Input: candidates = [2,3,6,7], target = 7,
             A solution set is:
             [
               [7],
               [2,2,3]
             ]
             Example 2:

             Input: candidates = [2,3,5], target = 8,
             A solution set is:
             [
               [2,2,2,2],
               [2,3,3],
               [3,5]
             ]


             Constraints:

             1 <= candidates.length <= 30
             1 <= candidates[i] <= 200
             Each element of candidate is unique.
             1 <= target <= 500
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }


}

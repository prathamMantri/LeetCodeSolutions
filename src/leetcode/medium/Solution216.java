package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution216 {
    // Help from https://leetcode.com/problems/combination-sum-iii/discuss/842853/Java-Backtracking-Solution-Easy-to-Understand
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        findComb(1, n, k, new LinkedList(), res);
        return res;
    }
    void findComb(int start, int n, int k, LinkedList<Integer> comb, List<List<Integer>> res) {
        if (comb.size() == k && n == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            findComb(i + 1, n - i, k, comb, res);
            comb.removeLast();
        }
    }
}

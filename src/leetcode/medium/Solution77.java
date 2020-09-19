package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * You may return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * Example 2:
     * <p>
     * Input: n = 1, k = 1
     * Output: [[1]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 20
     * 1 <= k <= n
     *
     * @param n
     * @param k
     * @return
     */


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

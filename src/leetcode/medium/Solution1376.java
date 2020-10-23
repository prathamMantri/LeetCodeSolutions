package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < manager.length; i++) {
            max = Math.max(max, helper(map, i, manager, informTime));
        }
        return max;
    }

    int helper(Map<Integer, Integer> map, int eId, int[] manager, int[] informTime) {
        if (manager[eId] == -1) {
            return 0;
        }
        if (map.containsKey(eId)) return map.get(eId);
        map.put(eId, informTime[manager[eId]] + helper(map, manager[eId], manager, informTime));
        return map.get(eId);
    }
}

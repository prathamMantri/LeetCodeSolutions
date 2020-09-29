package leetcode.easy;

import java.util.List;

public class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = arrays.get(0).get(0), min2, max1 = arrays.get(0).get(arrays.get(0).size() - 1), max2, currentDistance = 0, maxDistance = 0;
        for (int i = 1; i < arrays.size(); i++) {
            min2 = arrays.get(i).get(0);
            max2 = arrays.get(i).get(arrays.get(i).size() - 1);
            currentDistance = Math.max(Math.abs(max2 - min1), Math.abs(max1 - min2));
            maxDistance = Math.max(maxDistance, currentDistance);
            min1 = Math.min(min1, min2);
            max1 = Math.max(max1, max2);
        }
        return maxDistance;
    }
}

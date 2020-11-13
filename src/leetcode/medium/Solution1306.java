package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> indexSet = new HashSet<>();
        indexSet.add(start);
        return traverse(arr, indexSet, start + arr[start]) || traverse(arr, indexSet, start - arr[start]);
    }

    boolean traverse(int[] arr, Set<Integer> indexSet, int pos) {
        if (pos < 0 || pos > arr.length - 1 || indexSet.contains(pos))
            return false;
        if (arr[pos] == 0)
            return true;
        indexSet.add(pos);
        return traverse(arr, indexSet, pos + arr[pos]) || traverse(arr, indexSet, pos - arr[pos]);
    }
}

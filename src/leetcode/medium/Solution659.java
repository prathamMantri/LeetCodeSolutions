package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution659 {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> available = new HashMap<>();
        Map<Integer, Integer> required = new HashMap<>();
        for (int i : nums) {
            available.put(i, available.getOrDefault(i, 0) + 1);
        }
        for (int key : nums) {
            if (available.get(key) <= 0) {
                continue;
            } else if (required.getOrDefault(key, 0) > 0) {
                available.put(key, available.getOrDefault(key, 0) - 1);
                required.put(key, required.getOrDefault(key, 0) - 1);
                required.put(key + 1, required.getOrDefault(key + 1, 0) + 1);
            } else if (available.getOrDefault(key, 0) > 0 && available.getOrDefault(key + 1, 0) > 0 && available.getOrDefault(key + 2, 0) > 0) {
                available.put(key, available.getOrDefault(key, 0) - 1);
                available.put(key + 1, available.getOrDefault(key + 1, 0) - 1);
                available.put(key + 2, available.getOrDefault(key + 2, 0) - 1);
                required.put(key + 3, required.getOrDefault(key + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}

package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray())
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) {
            if (!countMap.containsKey(c))
                return false;
            if (countMap.get(c) == 1) {
                countMap.remove(c);
            } else {
                countMap.put(c, countMap.get(c) - 1);
            }
        }
        return countMap.isEmpty();
    }
}

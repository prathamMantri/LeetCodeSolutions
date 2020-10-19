package leetcode.medium;

import java.util.*;

public class Solution763 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (char c : S.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        int partition = 0;
        for (char c : S.toCharArray()) {
            int count = charCountMap.get(c) - 1;
            charCountMap.put(c, count);
            set.add(c);
            partition++;
            if (count == 0)
                set.remove(c);
            if (set.isEmpty()) {
                res.add(partition);
                partition = 0;
            }
        }
        return res;
    }
}

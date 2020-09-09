package leetcode.easy;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> partitionGroup = new TreeMap<>();
        for (Integer num : deck) {
            partitionGroup.put(num, partitionGroup.getOrDefault(num, 0) + 1);
        }

        Set<Integer> keySet = partitionGroup.keySet();
        int gcd = partitionGroup.get(partitionGroup.keySet().iterator().next());

        for (Integer key : partitionGroup.keySet()) {
            int keyCount = partitionGroup.get(key);
            gcd = gcd(gcd, keyCount);
            if (gcd < 2)
                return false;

        }
        return true;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}

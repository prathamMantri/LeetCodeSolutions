package leetcode.medium;

import java.util.TreeMap;

public class Solution846 {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> hands = new TreeMap<>();
        int count = W;
        for (int i : hand) {
            hands.put(i, hands.getOrDefault(i, 0) + 1);
        }
        while (!hands.isEmpty()) {
            int key = hands.firstKey();
            int nextKey = key + 1;
            if (hands.get(key) == 1)
                hands.remove(key);
            else
                hands.replace(key, hands.get(key) - 1);
            while (count > 1) {
                if (hands.containsKey(nextKey)) {
                    if (hands.get(nextKey) == 1)
                        hands.remove(nextKey);
                    else
                        hands.replace(nextKey, hands.get(nextKey) - 1);
                    nextKey = nextKey + 1;
                    count--;
                } else {
                    return false;
                }
            }
            count = W;
        }
        return true;
    }
}

package leetcode.hard;

import java.util.*;

public class Solution465 {
    int ans = 0;

    public int minTransfers(int[][] transactions) {
        int[] settlement = buildArray(transactions);
        return ans + findMinimumTransaction(settlement, 0);
    }

    private int[] buildArray(int[][] transactions) {
        Map<Integer, Integer> lendersMap = new HashMap<>();
        for (int[] transaction : transactions) {
            int amount = transaction[2];
            lendersMap.put(transaction[0], lendersMap.getOrDefault(transaction[0], 0) + amount);
            lendersMap.put(transaction[1], lendersMap.getOrDefault(transaction[1], 0) - amount);
        }
        List<Integer> withoutZeros = new ArrayList<>();

        int index = 0;
        for (int val : lendersMap.values())
            if (val != 0)
                withoutZeros.add(val);
        int[] values = new int[withoutZeros.size()];

        for (int val : withoutZeros)
            values[index++] = val;

        Arrays.sort(values);

        HashSet<Integer> set = new HashSet<>();
        int l = 0;
        int r = values.length - 1;

        while (l < r) {
            if (values[l] + values[r] == 0) {
                ans++;
                set.add(l++);
                set.add(r--);
            } else if (values[l] + values[r] < 0) l++;
            else r--;
        }
        int[] res = new int[values.length - set.size()];
        index = 0;
        for (int i = 0; i < values.length; i++)
            if (!set.contains(i))
                res[index++] = values[i];

        return res;
    }

    private int findMinimumTransaction(int[] res, int pos) {
        while (pos < res.length && res[pos] == 0) pos++;
        if (pos == res.length)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = pos + 1; i < res.length; i++) {
            if (res[pos] * res[i] < 0) {
                res[i] = res[i] + res[pos];
                min = Math.min(min, 1 + findMinimumTransaction(res, pos + 1));
                res[i] = res[i] - res[pos];
            }
        }
        return min;
    }
}

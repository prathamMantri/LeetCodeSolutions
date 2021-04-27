package leetcode.medium;

import java.util.*;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map1.put(i, 0);
        }

        for (int[] pre : prerequisites) {
            map1.put(pre[0], map1.get(pre[0]) + 1);

            if (!map2.containsKey(pre[1]))
                map2.put(pre[1], new ArrayList<>());
            map2.get(pre[1]).add(pre[0]);

        }

        Queue<Integer> qu = new LinkedList<>();

        for (int key : map1.keySet()) {
            if (map1.get(key) == 0)
                qu.add(key);
        }

        if (qu.isEmpty())
            return new int[0];

        int[] res = new int[numCourses];
        int index = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int curr = qu.poll();
                map1.put(curr, map1.get(curr) - 1);
                res[index] = curr;
                if (map2.containsKey(res[index++])) {
                    List<Integer> currList = map2.get(res[index - 1]);
                    if (currList != null)
                        for (int next : currList)
                            if (map1.get(next) == 0) qu.offer(next);
                }
            }
        }
        return res;
    }
}

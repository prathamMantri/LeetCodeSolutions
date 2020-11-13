package leetcode.hard;

import java.util.*;

public class Solution1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return 0;
        Map<Integer, List<Integer>> indicesMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int steps = 0;
        for (int i = 0; i < n; i++)
            indicesMap.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n - 1) {
                    return steps;
                }
                List<Integer> list = indicesMap.get(arr[curr]);
                list.add(curr + 1);
                list.add(curr - 1);
                for (int index : list) {
                    if (index >= 0 && index < n && !visited[index]) {
                        visited[index] = true;
                        q.offer(index);
                    }
                }
                list.clear();
            }
            steps++;
        }
        return steps;
    }
}

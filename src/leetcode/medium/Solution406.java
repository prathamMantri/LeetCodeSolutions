package leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for (int[] person : people) {
            q.add(person);
        }
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = q.poll();
            res.add(person[1], person);
        }
        return res.toArray(new int[res.size()][2]);
    }
}

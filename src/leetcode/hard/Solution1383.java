package leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //eff: 5   4    3   9   7  2
        //spd: 2   10   3   1   5  8

        //eff:      9   7   5   4   3   2
        //spd:      1   5   2   10  3   8

        //perf1:    9   35  10  40  9   16 // k=1
        //perf2:

        int[][] performances = new int[n][2];

        for (int i = 0; i < n; i++) {
            performances[i][0] = efficiency[i];
            performances[i][1] = speed[i];
        }

        Arrays.sort(performances, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int sum = 0;
        int res = 0;
        for (int[] performance : performances) {
            sum = sum + performance[1];
            pq.add(performance[1]);
            if (pq.size() > k) sum = sum - pq.poll();
            res = Math.max(res, (sum * performances[0][0]));
        }
        return res;
    }
}

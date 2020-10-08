package leetcode.medium;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Solution1086 {
    public int[][] highFive(int[][] items) {

        Map<Integer, PriorityQueue<Integer>> studentScore = new TreeMap<>();
        PriorityQueue<Integer> maxHeapScore;

        for (int i = 0; i < items.length; i++) {
            maxHeapScore = studentScore.get(items[i][0]);
            if (maxHeapScore == null) {
                maxHeapScore = new PriorityQueue<>((a, b) -> b - a);
                maxHeapScore.add(items[i][1]);
                studentScore.put(items[i][0], maxHeapScore);
            } else {
                maxHeapScore.add(items[i][1]);
                studentScore.put(items[i][0], maxHeapScore);
            }
        }
        Set<Integer> ids = studentScore.keySet();
        int[][] res = new int[ids.size()][2];
        int i = 0;
        for (Integer id : ids) {
            maxHeapScore = studentScore.get(id);
            int divide = 0;
            int score = 0;
            while (divide < 5 && maxHeapScore.size() > 0) {
                int currentScore = maxHeapScore.remove();
                score = score + currentScore;
                divide++;
            }
            res[i][0] = id;
            res[i][1] = score / divide;
            i++;
        }
        return res;
    }
}

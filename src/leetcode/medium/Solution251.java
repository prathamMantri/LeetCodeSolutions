package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution251 {


    Queue<Integer> queue = new LinkedList<>();
    int[][] v;

    public Solution251(int[][] v) {
        this.v = v;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                queue.add(v[i][j]);
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

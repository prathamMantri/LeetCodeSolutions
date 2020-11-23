package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1293 {
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> qu = new LinkedList<>();
        int[][][] visited = new int[grid.length][grid[0].length][k + 1];
        int level = -1;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        qu.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!qu.isEmpty()) {
            level++;
            int size = qu.size();
            for (int i = 0; i < size; i++) {

                int[] current = qu.poll();
                assert current != null;
                int r = current[0];
                int c = current[1];
                int o = current[2];

                if (r == grid.length - 1 && c == grid[0].length - 1)
                    return level;


                for (int[] dir : directions) {
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextO = o;
                    if (nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length) {
                        if (grid[nextR][nextC] == 1) {
                            nextO++;
                        }
                        if (nextO <= k && visited[nextR][nextC][nextO] == 0) {
                            qu.offer(new int[]{nextR, nextC, nextO});
                            visited[nextR][nextC][nextO] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

package leetcode.medium;

public class Solution1921 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] > 0)
                    max = Math.max(max, findPath(i, j, grid, visited));
        return max;
    }

    int findPath(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int up = findPath(i - 1, j, grid, visited);
        int down = findPath(i + 1, j, grid, visited);
        int left = findPath(i, j - 1, grid, visited);
        int right = findPath(i, j + 1, grid, visited);
        visited[i][j] = false;
        return Math.max(Math.max(up, down), Math.max(left, right)) + grid[i][j];
    }
}

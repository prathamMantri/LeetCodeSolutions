package leetcode.medium;

public class Solution994 {

    int count;

    public static void main(String[] args) {
        Solution994 sol = new Solution994();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(sol.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1)
                    continue;
                if (grid[i][j] == 2) {
                    dfs(grid, i, j);
                }
            }
        }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    return -1;

        return count;
    }

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        } else {
            grid[i][j] = 2;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
        count++;
    }
}

package leetcode.hard;

public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {

        int max = 0;

        if (matrix.length == 0 || matrix == null) {
            return max;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                max = Math.max(max, traverse(i, j, 1, matrix, dp, visited, Integer.MIN_VALUE));
        return max;
    }

    private int traverse(int i, int j, int count, int[][] matrix, int[][] dp, boolean[][] visited, int prev) {

        if (i <= 0 || i > matrix.length || j <= 0 || j > matrix[0].length || visited[i][j] || matrix[i][j] < prev)
            return count - 1;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        visited[i][j] = true;
        count = Math.max(
                Math.max(
                        traverse(i, j - 1, count, matrix, dp, visited, matrix[i][j]),
                        traverse(i, j + 1, count, matrix, dp, visited, matrix[i][j])
                ),
                Math.max(
                        traverse(i - 1, j, count, matrix, dp, visited, matrix[i][j]),
                        traverse(i + 1, j, count, matrix, dp, visited, matrix[i][j])
                )
        ) + 1;

        visited[i][j] = false;

        dp[i][j] = count;

        return count;

    }

}

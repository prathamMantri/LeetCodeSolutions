package leetcode.medium;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] results = new int[m][n];
        results[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    results[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        results[i][j] = results[i == 0 ? 0 : i - 1][j == 0 ? 0 : j - 1];
                    } else {
                        results[i][j] = results[i - 1][j] + results[i][j - 1];
                    }
                }
            }
        }
        return results[m - 1][n - 1];
    }
}

package leetcode.medium;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else {
            int[][] results = new int[m][n];
            results[0][0] = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        results[i][j] = 0;
                    }
                    if (i == 0 || j == 0) {
                        results[i][j] = 1;
                    } else {
                        results[i][j] = results[i - 1][j] + results[i][j - 1];
                    }
                }
            }
            return results[m - 1][n - 1];
        }
    }
}

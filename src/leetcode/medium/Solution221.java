package leetcode.medium;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {

        // Official Leetcode solution.
        int[][] dp = new int[matrix.length][matrix.length];
        int maxSquare = 0;
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
        return dp[matrix.length - 1][matrix.length - 1];
    }
}

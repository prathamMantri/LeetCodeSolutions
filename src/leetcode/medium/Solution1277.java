package leetcode.medium;

public class Solution1277 {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxSquare = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1;
                }
                maxSquare = maxSquare + matrix[i][j];
            }
        return maxSquare;
    }
}

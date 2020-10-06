package leetcode.medium;

public class Solution542 {

    public int[][] updateMatrix(int[][] matrix) {

        int[][] res = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0)
                    res[i][j] = 0;
                else {
                    if (i > 0)
                        res[i][j] = Math.min(matrix[i - 1][j], matrix[i][j] + 1);
                    if (j > 0)
                        res[i][j] = Math.min(matrix[i][j - 1], matrix[i][j] + 1);
                }

        for (int i = matrix.length - 1; i >= 0; i--)
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (i < matrix.length - 1)
                    res[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                if (j < matrix[0].length - 1)
                    res[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
            }
        return res;
    }
}

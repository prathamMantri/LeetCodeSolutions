package leetCode.medium;

class Solution73 {
    public void setZeroes(int[][] matrix) {

        boolean rowHasZero = false;
        boolean columnHasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                nullifyColumn(matrix, i);
            }
        }

        if (rowHasZero)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;

        if (columnHasZero)
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++)
            matrix[row][i] = 0;
    }

    void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][column] = 0;
    }

    public static void main(String... args) {
        Solution73 sol = new Solution73();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        sol.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

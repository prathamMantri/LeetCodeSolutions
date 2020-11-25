package leetcode.medium;

public class Solution308 {
    /*  public static class NumMatrix {

          private int[][] rowSums;
          private int[][] matrix;

          public NumMatrix(int[][] matrix) {

              if (matrix.length == 0 || matrix[0].length == 0)
                  return;

              this.matrix = matrix;
              rowSums = new int[matrix.length][matrix[0].length + 1];

              for (int i = 0; i < matrix.length; i++) {
                  for (int j = 1; j < matrix[0].length; j++) {
                      rowSums[i][j] = rowSums[i][j-1] + matrix[i][j-1];
                  }
              }
          }

          public void update(int row, int col, int val){
              for(int i=col+1;  i<rowSums.length; i++){
                  rowSums[row][i] = rowSums[row][i] - matrix[row][col] + val;
              }
              matrix[row][col] = val;
          }

          public int sumRegion(int row1, int col1, int row2, int col2){

              int ret = 0;
              for(int i= row1; i<=row2; i++){
                  ret = ret + rowSums[i][col2+1] - rowSums[i][col1];
              }

              return ret;
          }


      }*/
    public static class NumMatrix {
        private int[][] colSums;
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null
                    || matrix.length == 0
                    || matrix[0].length == 0) {
                return;
            }

            this.matrix = matrix;

            int m = matrix.length;
            int n = matrix[0].length;
            colSums = new int[m + 1][n];
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
                }
            }

            for (int i = 0; i <= m; i++) {
                System.out.println();
                for (int j = 0; j < n; j++) {
                    System.out.print("      " + colSums[i][j]);
                }
            }

        }

        //time complexity for the worst case scenario: O(m)
        public void update(int row, int col, int val) {
            for (int i = row + 1; i < colSums.length; i++) {
                colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
            }
            System.out.println();
            System.out.println();
            for (int i = 0; i <= matrix.length; i++) {
                System.out.println();
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print("      " + colSums[i][j]);
                }
            }

            matrix[row][col] = val;
        }

        //time complexity for the worst case scenario: O(n)
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ret = 0;

            for (int j = col1; j <= col2; j++) {
                ret += colSums[row2 + 1][j] - colSums[row1][j];
            }

            return ret;
        }
    }


}

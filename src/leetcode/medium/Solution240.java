package leetcode.medium;

public class Solution240 {
     /*  // *******Recursive Solution  *****
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix.length-1, 0,matrix, target);
    }

    private boolean searchMatrix(int x, int y, int[][]matrix, int target){

        if(x == matrix.length || x < 0 || y==matrix[0].length || y <0)
            return false;

        if(matrix[x][y]==target)
            return true;

        if(matrix[x][y] > target)
            return searchMatrix(--x, y, matrix, target);
        else
            return searchMatrix(x, ++y, matrix, target);
    }
    */
    // *******Iterative Solution  *****

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target)
                return true;

            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}

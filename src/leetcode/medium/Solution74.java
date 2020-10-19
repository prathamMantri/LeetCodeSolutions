package leetcode.medium;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        while (matrix[i][cols - 1] < target && i < rows - 1) {
            i++;
        }
        int[] targetInRow = new int[rows];
        targetInRow = matrix[i];
        return BinarySearch(targetInRow, target, 0, cols);
    }

    public boolean BinarySearch(int[] matrix, int target, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            if (target == matrix[mid])
                return true;
            else if (target < matrix[mid])
                return BinarySearch(matrix, target, low, mid);
            else if (target > matrix[mid])
                return BinarySearch(matrix, target, mid + 1, high);
            else
                return false;
        }
        return false;
    }
}

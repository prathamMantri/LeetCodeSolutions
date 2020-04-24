package leetcode.medium;

class Solution64 {
    public int minPathSum(int[][] grid) {

        int[][] minimum = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    minimum[i][j] = grid[i][j];
                } else if (i == 0 && j > 0) {
                    minimum[i][j] = minimum[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    minimum[i][j] = minimum[i - 1][j] + grid[i][j];
                } else {
                    minimum[i][j] = Math.min(minimum[i][j - 1] + grid[i][j], minimum[i - 1][j] + grid[i][j]);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println(minimum[i][j]);
            }
        }
        return minimum[grid.length - 1][grid[0].length - 1];
    }
}

package leetcode.easy;

public class Solution1351 {
    public static void main(String[] args) {

        Solution1351 sol = new Solution1351();
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        System.out.println(sol.countNegatives(grid));


    }

    public int countNegatives(int[][] grid) {

        int count = 0;
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        for (int[] arr : grid) {
            int index = findIndex(arr);
            count = count + arr.length - index;
        }
        return count;
    }

    int findIndex(int[] arr) {
        int start = 0;
        int end = arr.length;
        int index = end;
        if (arr[start] < 0) {
            return 0;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= 0) {
                start = mid + 1;
            } else {
                if (mid > 0 && arr[mid - 1] >= 0) {
                    index = mid;
                    break;
                }
                end = mid;
            }
        }

        return index;

    }

}

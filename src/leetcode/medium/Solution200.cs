
// https://leetcode.com/problems/number-of-islands/description/
public class Solution200 {
    public int NumIslands(char[][] grid) {
        if(grid.Length == 0)
        {
            return 0;
        }
        int count = 0;
        for(int i=0; i<grid.Length; i++)
        {
            for(int j=0; j<grid[0].Length; j++)
            {
                if(grid[i][j] == '1')
                {
                    ++count;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int i, int j)
    {
        if(i<0 || i>=grid.Length || j<0 || j>=grid[0].Length || grid[i][j] == '0')
        {
            return;
        }

        grid[i][j] = '0';

        DFS(grid, i, j-1);
        DFS(grid, i, j+1);
        DFS(grid, i+1, j);
        DFS(grid, i-1, j);

    }
}

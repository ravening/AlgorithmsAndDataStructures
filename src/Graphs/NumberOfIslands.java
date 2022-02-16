package Graphs;

public class NumberOfIslands {
    public int solution(int[][] grid) {
        int count = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i , j);
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x > grid.length || y < 0 || y > grid[0].length || grid[x][y] != 1)
            return;

        grid[x][y] = -1;

        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}

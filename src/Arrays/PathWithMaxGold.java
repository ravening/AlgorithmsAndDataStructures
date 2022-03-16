package Arrays;

/*
https://leetcode.com/problems/path-with-maximum-gold/discuss/398388/C%2B%2BJavaPython-DFS-Backtracking-Clean-code-O(3k)
 */
public class PathWithMaxGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, dfs(grid, i, j, grid.length, grid[0].length));
                }
            }
        }

        return max;
    }

    public int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int dfs(int[][] grid, int x, int y, int m, int n) {
        if (!isValid(x, y, m, n) || grid[x][y] == 0)
            return 0;

        int tmp = grid[x][y];
        int max = 0;
        grid[x][y] = 0;

        for (var dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValid(newX, newY, m , n) && grid[newX][newY] > grid[x][y]) {
                max = Math.max(max, grid[x][y] + dfs(grid, newX, newY, m, n));
            }
        }

        grid[x][y] = tmp;
        return max + grid[x][y];

    }

    public boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && y >= 0 && x < m && y < n);
    }

    public static void main(String[] args) {
        PathWithMaxGold maxGold = new PathWithMaxGold();
        int[][] grid = {{1, 0 , 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0 ,20}};

        System.out.println(maxGold.getMaximumGold(grid));
    }
}

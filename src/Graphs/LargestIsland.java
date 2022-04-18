package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestIsland {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int index = 10;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    map.put(index, dfs(grid, i, j, m, n, index));
                    result = Math.max(result, map.get(index));
                    index++;
                }
            }
        }

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> set = new HashSet<>();
                    for (var dir : direction) {
                        int newX = i + dir[0];
                        int newY = j + dir[1];

                        if (isValid(newX, newY, m, n) && grid[newX][newY] > 1 && !set.contains(grid[newX][newY])) {
                            set.add(grid[newX][newY]);
                            cur += map.get(grid[newX][newY]);
                        }
                    }
                    result = Math.max(result, cur);
                }
            }
        }

        return result;
    }

    int[][] direction = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int dfs(int[][] grid, int x, int y, int m, int n, int index) {
        grid[x][y] = index;

        int area = 0;
        for (var dir : direction) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValid(newX, newY, m, n) && grid[newX][newY] == 1) {
                area += dfs(grid, newX, newY, m, n, index);
            }
        }

        return area + 1;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >=0 && y >=0 && x < m && y < n;
    }
}

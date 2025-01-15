package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC317 {

    public static void main(String[] args) {
        LC317 lc317 = new LC317();
        int[][] grid = {
            {1,0,2,0,1},
            {0,0,0,0,0},
            {0,0,1,0,0}
        };

        System.out.println(lc317.shortestDistance(grid));  // Output: 7
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int totalBuildings = 0;

        int[][] reach = new int[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    if (!bfs(grid, reach, distance, i, j)) {
                        return -1;
                    }
                }
            }
        }

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    minimum = Math.min(minimum, distance[i][j]);
                }
            }
        }

        return minimum == Integer.MAX_VALUE ?  -1 : minimum;
    }

    private boolean bfs(int[][] grid, int[][] reach, int[][] distance, int x, int y) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int level = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();

                for (int[] dir: direction) {
                    int newX = current.x + dir[0];
                    int newY = current.y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        reach[newX][newY]++;
                        distance[newX][newY] += level;
                        queue.add(new Pair(newX, newY));
                    }
                }
            }
            level++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    static record Pair(int x, int y) {}
}

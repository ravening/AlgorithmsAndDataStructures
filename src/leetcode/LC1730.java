package leetcode;

import java.util.LinkedList;
import java.util.Queue;

// shortest path to get food
public class LC1730 {

    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int startX = 0, startY = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new LinkedList<>();
        visited[startX][startY] = true;

        queue.add(new Point(startX, startY, 0));

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (grid[current.x][current.y] == '#') {
                return current.distance;
            }

            for (var dir : direction) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] != 'X' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY, current.distance + 1));
                }
            }
        }

        return -1;
    }

    record Point(int x, int y, int distance) {

    }
}

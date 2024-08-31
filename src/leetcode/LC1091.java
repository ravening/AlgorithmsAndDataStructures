package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/solutions/312706/java-bfs/
 */
public class LC1091 {

    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        visited[0][0] = true;
        int answer = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;

                if (x == m - 1 && y == n - 1) {
                    return answer + 1;
                }

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 0) {
                        queue.add(new Pair(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

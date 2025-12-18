package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class LC2290 {

    public int minimumObstacles(int[][] grid) {
        if (grid ==null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] dp = new int[m][n];
        int MAX = Integer.MAX_VALUE;

        for (int[] array : dp) {
            Arrays.fill(array, MAX);
        }

        Deque<Triplet> queue = new ArrayDeque<>();

        queue.offer(new Triplet(0, 0, grid[0][0]));

        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();

            for (int[] dir : dirs) {
                int newX = triplet.row() + dir[0];
                int newY = triplet.col() + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && dp[newX][newY] == MAX) {
                    if (grid[newX][newY] == 1) {
                        dp[newX][newY] = 1 + triplet.count();
                        queue.offer(new Triplet(newX, newY, dp[newX][newY]));
                    } else {
                        dp[newX][newY] = triplet.count();
                        queue.offerFirst(new Triplet(newX, newY, dp[newX][newY]));
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }

    static record Triplet(int row, int col, int count){}
}

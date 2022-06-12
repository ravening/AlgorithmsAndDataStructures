package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/663/discuss/2529
 */
public class WallsAndGates {

    public void solution(int[][] maze) {
        if (maze == null || maze.length == 0) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        int[] dir = new int[]{0, 1, 0, -1, 0};

        for (var i = 0; i < maze.length; i++) {
            for (var j = 0 ; j < maze[0].length; j++) {
                if (maze[i][j] == 0) {
                    queue.add(new Pair(i, j));
                }
            }
        }


        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (var i = 0; i < dir.length - 2; i++) {
                int newR = pair.x + dir[i];
                int newC = pair.y + dir[i + 1];

                if (newR >= 0 && newC >= 0 && newR < maze.length && newC <= maze[0].length &&
                    maze[newR][newC] == Integer.MAX_VALUE) {
                    maze[newR][newC] = maze[pair.x][pair.y] + 1;
                    queue.add(new Pair(newR, newC));
                }
            }
        }

    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

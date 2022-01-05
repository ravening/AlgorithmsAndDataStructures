package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
 */
public class KnightToTarget {
    static class Cell {
        int x;
        int y;
        int distance;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = 0;
        }
    }

    int rowX[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    int rowY[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    boolean[][] visited;
    int N;

    KnightToTarget(int n) {
        this.N = n;
        visited = new boolean[this.N + 1][this.N + 1];

        for (var arr : visited)
            Arrays.fill(arr, false);

        for (var i = 0; i <= this.N; i++) {
            visited[i][0] = false;
            visited[0][i] = false;
        }
    }

    private boolean isInside(int x, int y) {
        return (x > 0 && y > 0 && x <= this.N && y <= this.N);
    }

    public int solution(int[] knight, int[] target) {
        Queue<Cell> queue = new ArrayDeque<>();
        Cell origin = new Cell(knight[0], knight[1]);
        queue.add(origin);
        visited[knight[0]][knight[1]] = true;

        while (!queue.isEmpty()) {
            Cell tmp = queue.remove();
            if (tmp.x == target[0] && tmp.y == target[1]) {
                return tmp.distance;
            }

            for (var i = 0; i < rowX.length; i++) {
                int tmpX = tmp.x + rowX[i];
                int tmpY = tmp.y + rowY[i];

                if (isInside(tmpX, tmpY) && !visited[tmpX][tmpY]) {
                    Cell next = new Cell(tmpX, tmpY);
                    next.distance = tmp.distance + 1;
                    visited[tmpX][tmpY] = true;
                    queue.add(next);
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int n = 30;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 30, 30 };

        KnightToTarget knightToTarget = new KnightToTarget(n);

        System.out.println(knightToTarget.solution(knightPos, targetPos));
    }
}

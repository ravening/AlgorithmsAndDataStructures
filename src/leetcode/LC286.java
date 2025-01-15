package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC286 {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int INF = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();

        // collect all the gates
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        //direction array
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int distance = 0;

        // perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : direction) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];

                    if (newX < 0 || newY < 0 || newX > rooms.length - 1 || newY > rooms[0].length -1 || rooms[newX][newY] != INF) {
                        continue;
                    }

                    rooms[newX][newY] = distance;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    public static void main(String[] args) {
        LC286 lc286 = new LC286();
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
            {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
            {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        lc286.wallsAndGates(rooms);

        for (int[] row : rooms) {
            for (int cell : row) {
                System.out.print((cell == INF ? "INF" : cell) + "\t");
            }
            System.out.println();
        }
    }
}

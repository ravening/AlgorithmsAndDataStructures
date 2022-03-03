package Arrays;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/distance-between-closest-pair-of-islands/
 */
public class DistanceBetweenIslands {
    static class Pair {
        int x;
        int y;
        int id;

        Pair(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static int[] rows = {-1, 0, 1, 0};
    static int[] column = {0, 1, 0, -1};

    public int distanceBetweenIslands(int[][] graph) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[graph.length][graph[0].length];
        int[][] distance = new int[graph.length][graph[0].length];
        int id =1;
        for (var i = 0; i < graph.length; i++) {
            for (var j = 0; j < graph[0].length; j++) {
                if (visited[i][j] == 0 && graph[i][j] == 1) {
                    dfs(graph, visited, i, j, queue, id);
                    id++;
                }
            }
        }

        return bfs(graph, visited, distance, queue);
    }

    private void dfs(int[][] graph, int[][] visited, int x, int y, Queue<Pair> queue, int id) {
        visited[x][y] = id;
        Pair pair = new Pair(x, y, id);
        queue.add(pair);

        for (var i = 0; i < 4; i++) {
            int newX = x + rows[i];
            int newY = y + column[i];

            if (isValid(newX, newY, graph.length, graph[0].length) &&
            visited[newX][newY] == 0 && graph[newX][newY] == 1) {
                dfs(graph, visited, newX, newY, queue, id);
            }
        }
    }

    private int bfs(int[][] graph, int[][] visited, int[][] distance, Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            for (var i = 0; i < 4; i ++) {
                int newX = pair.x + rows[i];
                int newY = pair.y + column[i];

                if (isValid(newX, newY, graph.length, graph[0].length)
                    && visited[newX][newY] == 0) {
                    queue.add(new Pair(newX, newY, pair.id));
                    distance[newX][newY] = distance[pair.x][pair.y] + 1;
                    visited[newX][newY] = pair.id;
                } else if (isValid(newX, newY, graph.length, graph[0].length) &&
                            visited[newX][newY] != 0 &&
                            visited[newX][newY] != pair.id) {
                    return distance[newX][newY] + distance[pair.x][pair.y];
                }
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return (x > 0 && y > 0 && x < m && y < n);
    }

    public static void main(String[] args)
    {
        DistanceBetweenIslands distanceBetweenIslands =
                new DistanceBetweenIslands();
        int[][] grid = { { 1, 0, 0, 0, 1 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1 } };
        System.out.println(distanceBetweenIslands.distanceBetweenIslands(grid));
    }
}

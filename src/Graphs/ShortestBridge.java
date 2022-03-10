package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/shortest-bridge/discuss/189321/Java-DFS-find-the-island-greater-BFS-expand-the-island
 */
public class ShortestBridge {
    private static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int solution(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[graph.length][graph[0].length];

        for (var i = 0; i < graph.length; i++) {
            boolean found = false;
            for (var j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    dfs(graph, queue, i, j, visited);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        return bfs(graph, queue, visited);
    }

    private static void dfs(int[][] graph, Queue<int[]> queue, int i, int j, int[][] visited) {
        if (isValid(i, j, graph.length, graph[0].length) && visited[i][j] == 0 && graph[i][j] == 1) {
            visited[i][j] = 1;
            queue.offer(new int[]{i,j});
            for (var d : dir) {
                int x = i + d[0];
                int y = j + d[1];
                dfs(graph, queue, x, y, visited);
            }
        }
    }

    private static int bfs(int[][] graph, Queue<int[]> queue, int[][] visited) {
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] tmp = queue.poll();
                for (var d : dir) {
                    int x = tmp[0] + d[0];
                    int y = tmp[1] + d[1];
                    if (isValid(x, y, graph.length, graph[0].length) && visited[x][y] != 0) {
                        if (graph[x][y] == 1)
                            return result;
                        visited[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            result++;
        }

        return -1;
    }
    private static boolean isValid(int x, int y, int m, int n) {
        return (x > 0 && y > 0 && x < m && y < n);
    }
}

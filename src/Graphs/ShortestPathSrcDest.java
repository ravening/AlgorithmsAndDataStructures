/*
https://www.geeksforgeeks.org/shortest-path-from-a-source-cell-to-a-destination-cell-of-a-binary-matrix-through-cells-consisting-only-of-1s/?ref=rp
 */
package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathSrcDest {
    int ROW;
    int COL;
    int[][] matrix;
    Point src;
    Point dest;

    ShortestPathSrcDest(int[][] mat, int r, int c, Point s, Point d) {
        this.matrix = mat;
        this.ROW = r;
        this.COL = c;
        this.src = s;
        this.dest = d;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        Point p;
        int distance;

        public Node(Point p, int distance) {
            this.p = p;
            this.distance = distance;
        }
    }

    int[] row = {-1, 0, 1, 0};
    int[] col = {0, 1, 0, -1};

    private boolean isValidPoint(int x, int y) {
        return (x >= 0 && x <ROW && y >= 0 && y < COL);
    }

    public void shortestPath() {
        int[][] dist = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Node> queue = new ArrayDeque<>();
        for (int[] arr: dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (var arr : visited) {
            Arrays.fill(arr, false);
        }

        visited[src.x][src.y] = true;
        dist[src.x][src.y] = 0;

        Node node = new Node(new Point(src.x, src.y), 0);
        queue.add(node);

        process(queue, dist, visited);
    }

    private void process(Queue<Node> queue, int[][] dist, boolean[][] visited) {
        boolean found = false;
        while (!queue.isEmpty()) {
            Node tmp = queue.remove();

            if (tmp.p.x == dest.x && tmp.p.y == dest.y) {
                Point p = tmp.p;
                int xx = p.x;
                int yy = p.y;
                int distance = tmp.distance;
                StringBuilder sb = new StringBuilder();
                while (xx != src.x || yy != src.y) {
                    if (xx > 0 && dist[xx - 1][yy] == distance -1) {
                        sb.append("D");
                        xx--;
                    }
                    if (xx < ROW - 1 && dist[xx + 1][yy] == distance - 1) {
                        sb.append("U");
                        xx++;
                    }
                    if (yy > 0 && dist[xx][yy - 1] == distance - 1) {
                        sb.append("R");
                        yy--;
                    }
                    if (yy < COL - 1 && dist[xx][yy + 1] == distance -1) {
                        sb.append("L");
                        yy++;
                    }
                    distance--;
                }
                System.out.println(sb.reverse().toString());
                found = true;
                break;
            } else {
                for (var i = 0; i < 4; i++) {
                    int tRow = tmp.p.x + row[i];
                    int tCol = tmp.p.y + col[i];

                    if (isValidPoint(tRow, tCol) && !visited[tRow][tCol] && matrix[tRow][tCol] == 1) {
                        Node newNode = new Node(new Point(tRow, tCol), tmp.distance + 1);
                        queue.add(newNode);
                        visited[tRow][tCol] = true;
                        dist[tRow][tCol] = tmp.distance + 1;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No route");
        }
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 0, 1, 0, 1 },
                { 1, 0, 1, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 0 } };
        ShortestPathSrcDest shortestPathSrcDest = new ShortestPathSrcDest(mat,
                mat.length,
                mat[0].length,
                new Point(3, 0),
                new Point(0,3));

        shortestPathSrcDest.shortestPath();
    }
}

package Arrays;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    private int[] X = new int[]{-1, 1, 0 , 0};
    private int[] Y = new int[]{0, 0, -1, 1};

    public int solution(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int max = 0;
        if (row == 0 || col == 0)
            return 0;

        int[][] visited = new int[row][col];

        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                if (visited[i][j] != 1 && grid[i][j] == 1) {
                    int count = bfs(grid, visited, i, j);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int[][] visited, int i, int j) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j));
        visited[i][j] = 1;

        int count = 0;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (var x = 0; x < X.length; x++) {
                int newR = tmp.x + X[x];
                int newC = tmp.y + Y[x];

                if (isValid(newR, newC, grid.length, grid[0].length) && visited[newR][newC] == 0 && grid[newR][newC] == 1) {
                    queue.add(new Node(newR, newC));
                    visited[newR][newC] = 1;
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValid(int i, int j, int row, int col) {
        return (i >= 0 && j >= 0 && i < row && j < col);
    }

    private int numberOfIslands(int[][] grid) {
        int numberOfIslands = 0;
        DisjointSet disjointSet = new DisjointSet(grid.length * grid[0].length);

        int m = grid.length;
        int n = grid[0].length;

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                int tmp = i * m + j;
                if (isValid(i+1,j,m,n) && grid[i+1][j] == 1) {
                    disjointSet.union(tmp, tmp + m);
                }
                if (isValid(i-1, j, m, n) && grid[i-1][j] == 1) {
                    disjointSet.union(tmp, tmp - m);
                }
                if (isValid(i, j + 1, m , n) && grid[i][j+1] == 1) {
                    disjointSet.union(tmp, tmp + 1);
                }
                if (isValid(i, j -1, m , n) && grid[i][j-1] == 1) {
                    disjointSet.union(tmp, tmp - 1);
                }
            }
        }

        for (var i = 0; i < m * n; i++) {
            if (disjointSet.id[i] == i && grid[i / n][i % n] == 1)
                numberOfIslands++;
        }

        return numberOfIslands;
    }

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class DisjointSet {
        int[] size;
        int[] id;

        DisjointSet(int n) {
            size = new int[n];
            id = new  int[n];
            makeSet();
        }

        private void makeSet() {
            for (var i = 0; i < size.length; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }

        private int find(int x) {
            while (id[x] != x) {
                x = id[x];
            }

            return x;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            if (size[rootX] < size[rootY]) {
                size[rootY] += size[rootX];
                id[rootX] = id[rootY];
            } else {
                size[rootX] += size[rootY];
                id[rootY] = id[rootX];
            }
        }
    }
}


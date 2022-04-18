package Graphs;

/**
 * Program to check if the given edges form a valid tree or not
 */
public class ValidTree {
    static class UnionFind {
        int count;
        int[] children;

        UnionFind(int n) {
            this.count = n;
            children = new int[count];
        }
    
        private int getCount() {
            return count;
        }

        private int find(int x) {
            while (x != children[x]) {
                children[x] = find(children[x]);
            }

            return x;
        }

        private void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                children[rootX] = rootY;
                this.count--;
            }
        }
    }

    public boolean isValidTree(int n, int[][] edges) {
        if (n <= 0 || edges == null) {
            return false;
        }

        if (edges.length != n - 1) {
            return false;
        }

        UnionFind unionFind = new UnionFind(n);

        for (var edge : edges) {
            int x = edge[0];
            int y = edge[1];

            unionFind.merge(x, y);
        }

        return unionFind.getCount() == 1;
    }
}

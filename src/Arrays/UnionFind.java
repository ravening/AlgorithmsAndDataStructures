package Arrays;

public class UnionFind {

    int size;
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        size = n;
        parent = new int[size];
        rank = new int[size];

        for (var i = 0; i < size ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            x = find(parent[x]);
        }

        return x;
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY)
            return;

        if (rank[parentX] >= rank[parentY]) {
            parent[parentY] = parentX;
            rank[parentX] += rank[parentY];
        } else {
            parent[parentX] = parentY;
            rank[parentY] += rank[parentX];
        }
    }
}

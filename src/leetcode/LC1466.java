package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/solutions/661672/c-java-track-direction/
 *
 * Use java union find
 */
public class LC1466 {

    public int minReorder(int[][] connections, int n) {
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }

        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < connections.length; i++) {
            queue.add(new Pair(connections[i][0], connections[i][1]));
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int x = find(map, pair.getSrc());
            int y = find(map, pair.getDst());

            if (x == 0 && y != 0) {
                result++;
                map[y] = 0;
            } else if (x != 0 && y != 0) {
                queue.add(pair);
            } else {
                map[x] = 0;
                map[y] = 0;
            }
        }

        return result;
    }

    public int find(int[] map, int id) {
        while (map[id] != id) {
            map[id] = map[map[id]];
            id = map[id];
        }

        return id;
    }
}

class Pair {
    int src;
    int dst;
    public Pair(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }
}

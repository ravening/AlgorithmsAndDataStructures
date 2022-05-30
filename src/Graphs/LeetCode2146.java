package Graphs;

import java.util.*;

public class LeetCode2146 {

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        Queue<Item> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Item> output = new ArrayList<>();
        int[] dir = {0, 1, 0, -1 ,0};
        int row = grid.length;
        int col = grid[0].length;

        Set<Integer> set = new HashSet<>();
        set.add(start[0] * col + start[1]);
        queue.add(new Item(0, grid[start[0]][start[1]], start[0], start[1]));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.price >= pricing[0] && item.price <= pricing[1]) {
                output.add(item);
            }

            for (var i = 0; i< dir.length - 1; i++) {
                int newR = item.row + dir[i];
                int newC = item.col + dir[i+1];

                if (isValid(newR, newC, row, col) && !set.contains(newR * col + newC)) {
                    queue.add(new Item(item.dist + 1, grid[newR][newC], newR, newC));
                    set.add(newR * col + newC);
                }
            }
        }

        Collections.sort(output,
                (a, b) ->
                    a.dist == b.dist ?
                        a.price == b.price ?
                            a.row == b.row ?
                                a.col - b.col : a.row - b.row
                        : a.price - b.price :
                    a.dist - b.dist);

        for (var i = 0; i < output.size() && i < k; i++) {
            result.add(List.of(output.get(i).row, output.get(i).col));
        }

        return result;
    }


    private boolean isValid(int x, int y, int m, int n) {
        return (x >=0 && y>= 0 && x < m && y < n);
    }
    class Item {
        int dist;
        int price;
        int row;
        int col;

        Item(int d, int p, int r, int c) {
            this.dist = d;
            this.price = p;
            this.row = r;
            this.col = c;
        }
    }
}

package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/solutions/107404/java-solution-priorityqueue-bfs/
 */
public class LC675 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new LinkedList<>());
        lists.add(new LinkedList<>());
        lists.add(new LinkedList<>());

        lists.get(0).add(1);
        lists.get(0).add(2);
        lists.get(0).add(3);
        lists.get(1).add(0);
        lists.get(1).add(0);
        lists.get(1).add(4);
        lists.get(2).add(7);
        lists.get(2).add(6);
        lists.get(2).add(5);
        LC675 lc = new LC675();
        System.out.println(lc.cutOffTree(lists));
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int cutOffTree(List<List<Integer>> forest) {

        if (forest == null || forest.isEmpty()) {
            return 0;
        }

        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(GraphNode::height));

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new GraphNode(i, j, forest.get(i).get(j)));
                }
            }
        }
        int sum = 0;
        int x = 0, y = 0;
        while (!pq.isEmpty()) {
            GraphNode node = pq.poll();
            System.out.println("current tree is at " + node.row() + " " + node.col());
            int steps = bfs(forest, x, y, node);
            System.out.println("steps " + steps);
            if (steps < 0) {
                return -1;
            }
            sum += steps;
            x = node.row();
            y = node.col();
        }

        return sum;
    }

    public int bfs(List<List<Integer>> forest, int x, int y, GraphNode node) {
        System.out.println("x " + x + " y " + y);
        int steps = 0;
        int rowSize = forest.size();
        int colSize = forest.get(0).size();
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<GraphNode> q = new LinkedList<>();
        q.add(new GraphNode(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println("size " + size);
            for (int i = 0; i < size; i++) {
                GraphNode cur = q.poll();
                if (cur.row() == node.row() && cur.col() == node.col()) {
                    System.out.println("found tree at " + cur.row() + " " + cur.col());
                    return steps;
                }
                for (int[] dir : dir) {
                    int row = cur.row() + dir[0];
                    int col = cur.col() + dir[1];
                    System.out.println("new row " + row + " new col " + col);
                    if (row >= 0 && row < rowSize && col >= 0 && col < colSize &&
                            !visited[row][col] && forest.get(row).get(col) > 0) {
                        visited[row][col] = true;
                        q.add(new GraphNode(row, col, forest.get(row).get(col)));
                        System.out.println("adding new node " + row + " " + col);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}

record GraphNode(int row, int col, int height) {
}

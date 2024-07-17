package leetcode;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/solutions/5143287/beat-100-00-tc-and-94-05-sc-full-explanation-easy-for-beginners-to-understand/
 */
public class LC987 {

    public List<List<Integer>> verticalTraversal(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.col != b.col) {
                return a.col - b.col;
            } else if (a.row != b.row) {
                return a.row - b.row;
            } else {
                return a.val - b.val;
            }
        });

        dfs(root, 0, 0, pq);

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Node node = pq.poll();

            list.add(node.val);

            while (!pq.isEmpty() && pq.peek().col == node.col) {
                list.add(pq.poll().val);
            }

            res.add(list);
        }
        return res;
    }

    public void dfs(TreeNode<Integer> root, int row, int col, PriorityQueue<Node> priorityQueue) {
        if (root == null) {
            return;
        }

        priorityQueue.add(new Node(root.getData(), row, col));
        dfs(root.getLeft(), row + 1, col - 1, priorityQueue);
        dfs(root.getRight(), row + 1, col + 1, priorityQueue);
    }

}

class Node {
    int val;
    int row;
    int col;

    Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

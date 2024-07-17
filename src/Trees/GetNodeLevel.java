package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/get-level-node-binary-tree-iterative-approach/?ref=rp
 */
public class GetNodeLevel {
    public int getLevelOfNode(Trees.TreeNode<Integer> root, int x) {
        if (root == null)
            return -1;

        Queue<Trees.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Trees.TreeNode<Integer> tmp = queue.remove();
                if (tmp.getData() == x) {
                    return level;
                }

                if (tmp.getLeft() != null)
                    queue.add(tmp.getLeft());
                if (tmp.getRight() != null)
                    queue.add(tmp.getRight());

                size--;
            }
            level++;
        }

        return -1;
    }
}

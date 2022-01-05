package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/deepest-right-leaf-node-binary-tree-iterative-approach/?ref=rp
 */
public class DeepestRightandLeftNode {

    public src.Trees.TreeNode<Integer> deepestRightNode(src.Trees.TreeNode<Integer> root) {
        Queue<src.Trees.TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        src.Trees.TreeNode<Integer> result = null;

        while (!queue.isEmpty()) {
            src.Trees.TreeNode<Integer> tmp = queue.poll();

            if (tmp.getLeft() != null)
                queue.add(tmp.getLeft());

            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());

                if (tmp.getRight().getLeft().isLeafNode() && tmp.getRight().getRight().isLeafNode()) {
                    result = tmp.getRight();
                }
            }
        }

        return result;
    }
}

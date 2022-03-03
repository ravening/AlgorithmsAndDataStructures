package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/iterative-diagonal-traversal-binary-tree/
 */
public class DiagonalTraversal {
    public void solution(src.Trees.TreeNode<Integer> root) {
        Queue<src.Trees.TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            src.Trees.TreeNode<Integer> node = queue.poll();

            if (node != null) {
                while (node != null) {
                    if (node.getLeft() != null) {
                        queue.add(node.getLeft());
                    }
                    System.out.print(node.getData() + " ");
                    node = node.getRight();
                }

            } else {
                System.out.println();
                queue.add(null);
            }
        }
    }
}

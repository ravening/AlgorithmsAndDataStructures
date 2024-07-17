package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/print-left-and-right-leaf-nodes-separately-in-binary-tree/?ref=rp
 */
public class PrintLeafNodesSeparately {

    public static void printLeafNode(Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<Trees.TreeNode<Integer>> queue = new LinkedList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Trees.TreeNode<Integer> tmp = queue.remove();
                if (tmp.getLeft() != null) {
                    queue.add(tmp.getLeft());
                    if (tmp.getLeft().isLeafNode())
                        left.add(tmp.getLeft().getLeft().getData());
                }

                if (tmp.getRight() != null) {
                    if (tmp.getRight().isLeafNode())
                        right.add(tmp.getLeft().getLeft().getData());
                    queue.add(tmp.getRight());
                }

                size--;
            }
        }

        left.forEach(System.out::print);
        right.forEach(System.out::print);
    }
}

package Trees;

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/check-if-two-nodes-are-cousins-in-a-binary-tree-set-2/?ref=lbp

https://leetcode.com/problems/cousins-in-binary-tree/submissions/
 */
public class CousinNodes {
    static class Pair {
        Trees.TreeNode<Integer> node;
        Trees.TreeNode<Integer> parent;

        public Pair(TreeNode<Integer> node, TreeNode<Integer> parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean isCousin(TreeNode<Integer> root, TreeNode<Integer> nodeA, TreeNode<Integer> nodeB) {
        if (root == null)
            return false;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, new TreeNode<Integer>(-1)));

        TreeNode<Integer> parentA = null;
        TreeNode<Integer> parentB = null;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Pair tmp = queue.remove();

                if (tmp.node == nodeA)
                    parentA = tmp.parent;

                if (tmp.node == nodeB)
                    parentB = tmp.parent;

                if (tmp.node.getLeft() != null) {
                    queue.add(new Pair(tmp.node.getLeft(), tmp.node));
                }

                if (tmp.node.getRight() != null) {
                    queue.add(new Pair(tmp.node.getRight(), tmp.node));
                }

                if (parentA != null && parentB != null)
                    break;

                size--;
            }

            if (parentA != null && parentB != null)
                return parentA != parentB;

            if ((parentA != null && parentB == null) || (parentA == null && parentB != null))
                return false;
        }

        return false;
    }
}

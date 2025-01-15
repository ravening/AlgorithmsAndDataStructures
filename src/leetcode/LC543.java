package leetcode;

import Trees.TreeNode;

public class LC543 {

    static class Pair {
        int diameter;
        int height;

        Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair pair = diameterOfBinaryTreeHelper(root);
        return pair.diameter;
    }

    private Pair diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = diameterOfBinaryTreeHelper(root.getLeft());
        Pair right = diameterOfBinaryTreeHelper(root.getRight());

        int currentDiameter = left.height + right.height;
        int currentHeight = Math.max(left.height, right.height) + 1;

        int maxDiameter = Math.max(currentDiameter, Math.max(left.diameter, right.diameter));

        return new Pair(maxDiameter, currentHeight);
    }
}

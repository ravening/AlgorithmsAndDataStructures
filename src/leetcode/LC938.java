package leetcode;

import Trees.TreeNode;

/**
 * https://walkccc.me/LeetCode/problems/938/#__tabbed_1_2
 */
public class LC938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if ((Integer)root.getData() < low) {
            rangeSumBST(root.getRight(), low, high);
        }

        if ((Integer)root.getData() > high) {
            rangeSumBST(root.getLeft(), low, high);
        }

        return (Integer)root.getData() + rangeSumBST(root.getLeft(), low, high) + rangeSumBST(root.getRight(), low, high);
    }
}

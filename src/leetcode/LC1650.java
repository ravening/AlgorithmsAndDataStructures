package leetcode;

import Trees.TreeNode;

/**
 * https://walkccc.me/LeetCode/problems/1650/
 */
public class LC1650 {

    public TreeNodeWithParent lcaIII(TreeNodeWithParent p, TreeNodeWithParent q) {
        if (p == null && q == null) {
            return null;
        }

        TreeNodeWithParent a = p;
        TreeNodeWithParent b = q;

        while (a != b) {
            a = (a == null) ? q : a.parent;
            b = (b == null) ? p : b.parent;
        }

        return a;
    }

    static class TreeNodeWithParent {
        int val;
        TreeNodeWithParent parent;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
    }
}


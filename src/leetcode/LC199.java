package leetcode;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/solutions/56012/my-simple-accepted-solution-java/
 */
public class LC199 {

    public List<Integer> rightSideView(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, list, 0);

        return list;
    }

    private void helper(TreeNode<Integer> root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }

        if (list.size() == depth) {
            list.add(root.getData());
        }

        helper(root.getRight(), list, depth + 1);
        helper(root.getLeft(), list, depth + 1);
    }
}

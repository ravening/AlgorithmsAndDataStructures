package Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/print-the-longest-path-from-root-to-leaf-in-a-binary-tree/?ref=rp
 */
public class LongestRootLeafPath {
    public List<Integer> solution(src.Trees.TreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> left = solution(root.getLeft());
        List<Integer> right = solution(root.getRight());

        if (left.size() < right.size()) {
            right.add(root.getData());
        } else {
            left.add(root.getData());
        }

        return left.size() < right.size() ? right : left;
    }
}

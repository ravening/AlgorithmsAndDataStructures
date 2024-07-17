package Trees;

import java.util.HashMap;
import java.util.Map;

/*
https://www.techiedelight.com/maximum-independent-set-problem/
 */
public class MaximumIndependentSubset {

    public static int solution(TreeNode<Integer> root) {
        Map<TreeNode<Integer>, Integer> map = new HashMap<>();
        return get(root, map);
    }

    public static int get(TreeNode<Integer> root, Map<TreeNode<Integer>, Integer> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        // exclude the current node
        int exclude = get(root.getLeft(), map) + get(root.getRight(), map);

        // include
        int include = 1;
        if (root.getLeft() != null) {
            include += get(root.getLeft().getLeft(), map) + get(root.getLeft().getRight(), map);
        }

        if (root.getRight() != null) {
            include += get(root.getRight().getLeft(), map) + get(root.getRight().getRight(), map);
        }

        map.put(root, Math.max(include, exclude));
        return map.get(root);
    }
}

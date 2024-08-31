package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/5640287/google-l3-swe2-phone-screen
 */
public class SpecialNodeCount {

    public Map<Integer, Integer> getSpecialNodeCount(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        countNodes(root, 0, map);
        return map;
    }


    public void countNodes(TreeNode root, int count, Map<Integer, Integer> map) {
        if (root == null) return;

        if (root.isLeafNode()) {
            if (count > 0) {
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
            return;
        }

        if (root.getLeft() != null && root.getRight() != null) {
            if (count > 0) {
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
            countNodes(root.getLeft(), 0, map);
            countNodes(root.getRight(), 0, map);
        } else if (root.getLeft() != null) {
            countNodes(root.getLeft(), count + 1, map);
        } else {
            countNodes(root.getRight(), count + 1, map);
        }

    }
}

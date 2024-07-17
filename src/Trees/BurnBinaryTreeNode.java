package Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
 */
public class BurnBinaryTreeNode {

    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int burnTreeNode(TreeNode<Integer> rootNode, int key) {
        if (rootNode != null) {
            if (rootNode.getData() == key) {
                levelOrderTreeNode(rootNode.getLeft(), 1);
                levelOrderTreeNode(rootNode.getRight(), 1);
                return 1;
            }
            int k = burnTreeNode(rootNode.getLeft(), key);
            if (k > 0) {
                storeTreeNode(rootNode, k);
                levelOrderTreeNode(rootNode.getRight(), k + 1);
                return k + 1;
            }
            k = burnTreeNode(rootNode.getRight(), key);
            if (k > 0) {
                storeTreeNode(rootNode, k);
                levelOrderTreeNode(rootNode.getLeft(), k+1);
                return k + 1;
            }
        }

        return -1;
    }

    public void levelOrderTreeNode(TreeNode<Integer> node, int level) {
        if (node != null) {
            storeTreeNode(node, level);
            levelOrderTreeNode(node.getLeft(), level + 1);
            levelOrderTreeNode(node.getRight(), level + 1);
        }
    }

    public void storeTreeNode(TreeNode<Integer> node, int level) {
        if (!map.containsKey(level)) {
            Set<Integer> set = new HashSet<>();
            set.add(node.getData());
            map.put(level, set);
        } else {
            map.get(level).add(node.getData());
        }
    }
}

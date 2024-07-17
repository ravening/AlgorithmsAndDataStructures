package Trees;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/print-the-first-shortest-root-to-leaf-path-in-a-binary-tree/?ref=rp
 */
public class PrintShortestPath {
    public void solution(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        queue.add(root);
        map.put(root.getData() , root.getData());
        int leaf = 0;

        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();

            if (node.isLeafNode()) {
                leaf = node.getData();
                break;
            } else {
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                    map.put(node.getLeft().getData(), node.getData());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                    map.put(node.getRight().getData(), node.getData());
                }
            }
        }

        displayPath(map, leaf);
    }

    public void displayPath(Map<Integer, Integer> map, int key) {
        if (map.get(key) == key)
            return;

        displayPath(map, key);
        System.out.print(key + " ");
    }
}

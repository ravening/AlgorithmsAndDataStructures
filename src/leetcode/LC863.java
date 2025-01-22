package leetcode;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if (root == null) {
            return null;
        }

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (var i = 0 ; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.getLeft() != null) {
                    parentMap.put(current.getLeft(), current);
                    queue.offer(current.getLeft());
                }

                if (current.getRight() != null) {
                    parentMap.put(current.getRight(), current);
                    queue.offer(current.getRight());
                }
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);

        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();

            for (var i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                visited.add(current);
                if (current.getLeft() != null && !visited.contains(current.getLeft())) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null && !visited.contains(current.getRight())) {
                    queue.add(current.getRight());
                }
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                }
            }
            k--;
        }

        List<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            result.add((Integer) queue.poll().getData());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(3);
        TreeNode<Integer> left = new TreeNode<>(5);
        TreeNode<Integer> right = new TreeNode<>(1);
        TreeNode<Integer> leftLeft = new TreeNode<>(6);
        TreeNode<Integer> leftRight = new TreeNode<>(2);
        TreeNode<Integer> rightLeft = new TreeNode<>(0);
        TreeNode<Integer> rightRight = new TreeNode<>(8);
        TreeNode<Integer> leftRightLeft = new TreeNode<>(7);
        TreeNode<Integer> leftRightRight = new TreeNode<>(4);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        leftRight.setLeft(leftRightLeft);
        leftRight.setRight(leftRightRight);

        LC863 lc863 = new LC863();
        System.out.println(lc863.distanceK(root, root, 2));  // Output: [7, 4, 1]
    }
}

package leetcode;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class LC2385 {

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (var i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.getLeft() != null) {
                    parentMap.put(current.getLeft(), current);
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    parentMap.put(current.getRight(), current);
                    queue.add(current.getRight());
                }
            }
        }

        Set<TreeNode> visited = new HashSet<>();

        Optional<TreeNode> first = parentMap.keySet().stream()
                .filter(node -> node.getData().equals(start))
                .findFirst();

        if (first.isEmpty()) {
            if (root.getData().equals(start)) {
                first = Optional.of(root);
            } else {
                return 0;
            }
        }

        TreeNode firstNode = first.get();
        queue.add(firstNode);
        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("queuse elements are at time " + time);
            for (TreeNode node : queue) {
                System.out.print(node.getData() + " ");
            }
            System.out.println();
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
            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(5));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(null);
        root.getLeft().setRight(new TreeNode<>(4));
        root.getRight().setLeft(new TreeNode<>(10));
        root.getRight().setRight(new TreeNode<>(6));
        root.getLeft().getRight().setLeft(new TreeNode<>(9));
        root.getLeft().getRight().setRight(new TreeNode<>(2));

        LC2385 lc2385 = new LC2385();
        System.out.println(lc2385.amountOfTime(root, 1));  // Output: 2
//        System.out.println(lc2385.amountOfTime(root, 1));  // Output: 3
    }
}

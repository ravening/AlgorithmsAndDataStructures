package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        boolean leftToRight = false;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (var i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode<Integer> current = queue.pollFirst();
                    list.add(current.getData());

                    if (current.getLeft() != null) {
                        queue.addLast(current.getLeft());
                    }
                    if (current.getRight() != null) {
                        queue.addLast(current.getRight());
                    }
                } else {
                    TreeNode<Integer> current = queue.pollLast();
                    list.add(current.getData());

                    if (current.getRight() != null) {
                        queue.addFirst(current.getRight());
                    }
                    if (current.getLeft() != null) {
                        queue.addFirst(current.getLeft());
                    }
                }
            }

            leftToRight = !leftToRight;
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().setRight(new TreeNode<>(5));
        root.getRight().setLeft(new TreeNode<>(6));
        root.getRight().setRight(new TreeNode<>(7));

        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        List<List<Integer>> result = zigZagTraversal.zigzagLevelOrder(root);
        System.out.println(result);

    }

}

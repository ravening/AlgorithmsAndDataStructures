package Trees;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 */
public class InorderWithStack {
    public static void inorder(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            System.out.print(current.getData() + " ");
            current = current.getRight();

        }
    }

    public static void reverseInorder(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        Stack<TreeNode<Integer>> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getRight();
            }

            current = stack.pop();
            System.out.print(current.getData() + " ");
            current = current.getLeft();
        }
    }
}

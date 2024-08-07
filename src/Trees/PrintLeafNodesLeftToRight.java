package Trees;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/print-all-leaf-nodes-of-a-binary-tree-from-left-to-right-set-2-iterative-approach/?ref=rp
 */
public class PrintLeafNodesLeftToRight {

    Stack<Trees.TreeNode<Integer>> stack1 = new Stack<>();
    Stack<Trees.TreeNode<Integer>> stack2 = new Stack<>();

    /*
    https://www.geeksforgeeks.org/print-leaf-nodes-in-binary-tree-from-left-to-right-using-one-stack/?ref=rp
     */

    public void solutionUsingOneStack(Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        while (true) {
            if (root != null) {
                stack1.push(root);
                root = root.getLeft();
            } else {
                if (stack1.isEmpty())
                    return;

                if (stack1.peek().getRight() == null) {
                    root = stack1.pop();
                    if (root.getLeft() == null) {
                        System.out.println(root.getData());
                    }
                }

                while (stack1.peek().getRight() == root) {
                    root = stack1.pop();
                    if (stack1.isEmpty())
                        break;
                }

                if (stack1.peek().getRight() != null) {
                    root = stack1.peek().getRight();
                } else {
                    root = null;
                }
            }
        }
    }
    public void leafNodesLeftToRight(Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Trees.TreeNode<Integer> tmp = stack1.pop();

            if (tmp.getLeft() != null)
                stack1.push(tmp.getLeft());

            if (tmp.getRight() != null)
                stack1.push(tmp.getRight());

            if (tmp.isLeafNode())
                stack2.push(tmp);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getData() + " ");
        }
    }

    public void printRightToLeft(Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Trees.TreeNode<Integer> tmp = stack1.pop();

            if (tmp.getRight() != null)
                stack1.push(tmp.getRight());

            if (tmp.getLeft() != null)
                stack1.push(tmp.getLeft());

            if (tmp.isLeafNode()) {
                stack2.push(tmp);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getData() + " ");
        }
    }
}

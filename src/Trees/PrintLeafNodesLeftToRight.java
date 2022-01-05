package Trees;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/print-all-leaf-nodes-of-a-binary-tree-from-left-to-right-set-2-iterative-approach/?ref=rp
 */
public class PrintLeafNodesLeftToRight {

    Stack<src.Trees.TreeNode<Integer>> stack1 = new Stack<>();
    Stack<src.Trees.TreeNode<Integer>> stack2 = new Stack<>();

    public void leafNodesLeftToRight(src.Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            src.Trees.TreeNode<Integer> tmp = stack1.pop();

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

    public void printRightToLeft(src.Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            src.Trees.TreeNode<Integer> tmp = stack1.pop();

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

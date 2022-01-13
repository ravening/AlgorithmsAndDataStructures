package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/print-root-leaf-path-without-using-recursion/
 */
public class PrintRootLeafPath {
    public void solution(src.Trees.TreeNode<Integer> root) {
        Stack<src.Trees.TreeNode<Integer>> stack = new Stack<>();
        Map<src.Trees.TreeNode<Integer>, src.Trees.TreeNode<Integer>> map = new HashMap<>();

        map.put(root, null);
        stack.push(root);

        while (!stack.isEmpty()) {
            src.Trees.TreeNode<Integer> tmp = stack.pop();

            if (tmp.isLeafNode()) {
                printPath(tmp, map);
            }
            if (tmp.getRight() != null) {
                map.put(tmp.getRight(), tmp);
                stack.push(tmp.getRight());
            }
            if (tmp.getLeft() != null) {
                map.put(tmp.getLeft(), tmp);
                stack.push(tmp.getLeft());
            }
        }
    }

    public void printPath(src.Trees.TreeNode<Integer> node, Map<src.Trees.TreeNode<Integer>, src.Trees.TreeNode<Integer>> map) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            stack.push(node.getData());
            node = map.get(node);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public void printPathWithoutStack(src.Trees.TreeNode<Integer> node, Map<src.Trees.TreeNode<Integer>, src.Trees.TreeNode<Integer>> map) {
        src.Trees.TreeNode<Integer> tmp = node;
        src.Trees.TreeNode<Integer> current = null;
        while (tmp != null) {
            current = tmp;
            tmp = map.get(tmp);
        }

        while (map.containsKey(current)) {
            System.out.println(current.getData());
            current = map.get(current);
        }
    }
}

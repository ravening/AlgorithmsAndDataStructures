package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/print-root-leaf-path-without-using-recursion/?ref=lbp
 */
public class RootToLeafPathIterative {
    public void solution(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Map<Node, Node> parent = new HashMap<>();

        stack.push(root);
        parent.put(root, null);


        while (!stack.isEmpty()) {
            Node tmp = stack.pop();

            if (tmp.right == null && tmp.left == null) {
                printPath(tmp, parent);
            }

            if (tmp.right != null) {
                stack.push(tmp.right);
                parent.put(tmp.right, tmp);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
                parent.put(tmp.left, tmp);
            }
        }
    }

    private void printPath(Node node, Map<Node, Node> parent) {
        Stack<Node> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = parent.get(node);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

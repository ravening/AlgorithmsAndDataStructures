package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree-single-traversal/
 */
public class PrintCousinNodes {
    public void solution(Node root, Node node) {
        if (root == null || node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();

            while (size-- > 0) {
                Node tmp = queue.remove();

                if (tmp.left == node || tmp.right == node) {
                    found = true;
                } else {
                    if (tmp.left != null) {
                        queue.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.add(tmp.right);
                    }
                }
            }
        }

        if (found && queue.size() > 0) {
            while (!queue.isEmpty()) {
                Node tmp = queue.remove();
                System.out.print(tmp.val + " ");
            }
        }
    }
}

package Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/print-longest-leaf-leaf-path-binary-tree/?ref=lbp
 */
public class LeafToLeafPath {
    static class Pair {
        int leftHeight;
        int rightHeight;
        int diameter;
        boolean flag;
        Node node;

        Pair() {
            this.leftHeight = this.rightHeight = this.diameter = 0;
            this.flag = false;
            this.node = null;
        }
    }

    Pair pair = new Pair();

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (pair.diameter < (1 + left + right)) {
            pair.diameter = 1 + left + right;

            pair.node = root;

            pair.leftHeight = left;
            pair.rightHeight = right;
        }

        return 1 + Math.max(left, right);
    }

    private void diameter(Node root) {
        if (root == null)
            return;

        int height = getHeight(root);
        List<Integer> list = new ArrayList<>();
        getPath(pair.node.left, list, height);
        System.out.println(pair.node.val);
        getPath(pair.node.right, list, height);
    }

    private void getPath(Node root, List<Integer> list, int height) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (list.size() == height) {
            printPath(list);
            pair.flag = true;
            list.clear();
        }

        getPath(root.left, list, height);
        getPath(root.right, list, height);
    }

    private void printPath(List<Integer> list) {
        if (!pair.flag) {
            for (var i = list.size() - 1; i>= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

    public void leafToLeafPath(Node root) {
        diameter(root);
    }
}

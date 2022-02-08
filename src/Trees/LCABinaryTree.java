// Program to find the LCA in a binary tree
// It should handle the cases of non existance of one node also

package Trees;

public class LCABinaryTree {
    static boolean v1 = false, v2 = false;

    public Node lcaUtil(Node root, int val1, int val2) {
        if (root == null)
            return null;

        // Temporary result
        Node tmp = null;

        // If root matches one of the value then set it to true
        if (root.val == val1) {
            v1 = true;
            tmp = root;
        }

        if (root.val == val2) {
            v2 = true;
            tmp = root;
        }

        Node left = lcaUtil(root.left, val1, val2);
        Node right = lcaUtil(root.right, val1, val2);

        // If tmp is not null then we found one of the value . return it
        if (tmp != null) {
            return  tmp;
        }

        // If subtree returns the left and right values and if they are
        // not null return the current node as the lca
        if (left != null && right != null) {
            return root;
        }

        // If we found one value in either of the subtee, then return that node
        return left != null ? left : right;
    }

    public Node lca(int val1, int val2) {
        Node tmp = lcaUtil(new Node(5, null, null), val1, val2);

        // If we found both the nodes in tree then return lca
        // else return null
        if (v1 && v2) {
            return tmp;
        }

        return  null;
    }

    public int findLevel(Node root, int target, int level) {
        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            return level;
        }

        int left = findLevel(root.left, target, level + 1);
        return (left != -1) ? left : findLevel(root.right, target, level + 1);
    }

    public int findDistanceBetweenTwoNodes(Node a, Node b) {
        Node lca = lca(a.val, b.val);

        if (lca != null) {
            int d1 = findLevel(lca, a.val, 0);
            int d2 = findLevel(lca, b.val, 0);

            return d1 + d2;
        }

        return -1;
    }
}

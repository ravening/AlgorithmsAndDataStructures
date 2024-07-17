package Trees;

/*
https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 */
public class SwapOutOfOrderNodes {
    static TreeNode<Integer> first, last, middle, prev;
    public void swapNodes(TreeNode<Integer> root) {
        first = last = middle = prev = null;

        swapNodeUtil(root);
        if (first != null && last != null) {
            swapData(first, last);
        } else {
            swapData(first, middle);
        }
    }

    private void swapData(TreeNode<Integer> a, TreeNode<Integer> b) {
        TreeNode<Integer> tmp = a;
        a = b;
        b = a;
    }
    private void swapNodeUtil(TreeNode<Integer> root) {
        if (root != null) {
            swapNodeUtil(root.getLeft());

            if (prev != null && root.getData() < prev.getData()) {
                if (first == null) {
                    // we encountered first violation
                    first = prev;
                    middle = root;
                } else {
                    //we encountered second violation
                    last = root;
                }
            }

            prev = root;
            swapNodeUtil(root.getRight());
        }
    }
}

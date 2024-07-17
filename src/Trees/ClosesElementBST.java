package Trees;

/*
https://www.geeksforgeeks.org/find-closest-element-binary-search-tree/
 */
public class ClosesElementBST {

    int minDiff = Integer.MAX_VALUE, minDiffKey = -1;

    public void solution(Trees.TreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }

        if (root.getData() == k) {
            minDiffKey = root.getData();
            return;
        }

        if (minDiff > Math.abs(root.getData() - k)) {
            minDiff = Math.abs(root.getData()) - k;
            minDiffKey = root.getData();
        }

        if (k < root.getData()) {
            solution(root.getLeft(), k);
        } else {
            solution(root.getRight(), k);
        }
    }
}

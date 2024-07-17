package Trees;

/*
https://www.geeksforgeeks.org/remove-nodes-from-binary-tree-such-that-sum-of-all-remaining-root-to-leaf-paths-is-atleast-k/?ref=rp
 */
public class RootLeafPathWithSumK {
    public TreeNode<Integer> solution(TreeNode<Integer> root, int K) {
        return rootLeafPathWithSumK(root, K, root.getData());
    }

    public TreeNode<Integer> rootLeafPathWithSumK(TreeNode<Integer> root, int K, int sum) {
        if (root == null)
            return null;

        if (root.getLeft() != null) {
            root.setLeft(rootLeafPathWithSumK(root.getLeft(), K, sum + root.getData()));
        }

        if (root.getRight() != null) {
            root.setRight(rootLeafPathWithSumK(root.getRight(), K, sum + root.getData()));
        }

        if (root.isLeafNode() && sum < K) {
            root = null;
            return null;
        }

        return root;
    }
}

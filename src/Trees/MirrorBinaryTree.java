package Trees;

public class MirrorBinaryTree {
    public TreeNode<Integer> solution(TreeNode<Integer> root) {
        if (root == null)
            return null;

        solution(root.getLeft());

        solution(root.getRight());

        TreeNode<Integer> tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);

        return root;
    }
}

package Trees;

public class IdenticalTrees {
    public boolean solution(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return ((root1.getData() == root2.getData()) &&
                    (solution(root1.getLeft(), root2.getLeft())) &&
                    (solution(root1.getRight(),root2.getRight())));
        }

        return false;
    }
}

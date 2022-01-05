package Trees;

/*
https://practice.geeksforgeeks.org/problems/children-sum-parent/1
 */
public class ChildrenSumParent {
    public int solution(src.Trees.TreeNode<Integer> root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null))
            return 1;

        int sum = 0;

        if (root.getLeft() != null) {
            sum += root.getLeft().getData();
        }

        if (root.getRight() != null) {
            sum += root.getRight().getData();
        }

        boolean isSum = (sum == root.getData()) && (solution(root.getLeft()) == 1 && (solution(root.getRight()) == 1));

        return isSum ? 1 : 0;
    }
}

package Trees;

/*
https://leetcode.com/problems/diameter-of-binary-tree/discuss/1678768/Java-Easy-Recursive-Solution
 */
public class DiameterOfTree {
    static class Pair {
        int height;
        int diameter;

        public Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    public int diameter(src.Trees.TreeNode<Integer> root) {
        Pair pair = diameterHelper(root);
        return pair.diameter;
    }

    public Pair diameterHelper(src.Trees.TreeNode<Integer> root) {
        if (root == null)
            return new Pair(0, 0);

        Pair left = diameterHelper(root.getLeft());
        Pair right = diameterHelper(root.getRight());

        int leftDiameter = left.diameter;
        int rightDiameter = right.diameter;

        int dist = left.height + right.height;
        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));

        int height = Math.max(left.height, right.height) + 1;

        return new Pair(height, diameter);
    }
}

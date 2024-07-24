package Trees;

public class LongestConsecutiveSequence {
    int maxLength = 0;

    public int longestConsecutive(TreeNode<Integer> root) {
        if (root == null) return 0;
        dfs(root, root.getData(), 0);

        return maxLength;
    }

    public void dfs(TreeNode<Integer> root, int expected, int currentLength) {
        if (root == null) return;

        if (root.getData() == expected) {
            currentLength++;
        } else {
            currentLength = 1;
        }

        maxLength = Math.max(maxLength, currentLength);

        dfs(root.getLeft(), root.getData() + 1, currentLength);
        dfs(root.getRight(), root.getData() + 1, currentLength);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        TreeNode<Integer> root = new TreeNode<>(1);
        root.setRight(new TreeNode<>(3));
        root.getRight().setLeft(new TreeNode<>(2));
        root.getRight().setRight(new TreeNode<>(4));
        root.getRight().getRight().setRight(new TreeNode<>(5));

        System.out.println(lcs.longestConsecutive(root));
    }
}

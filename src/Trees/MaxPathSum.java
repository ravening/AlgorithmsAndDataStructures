package Trees;

import Trees.TreeNode;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class result {
    int val;
}
public class MaxPathSum {
    result res = new result();

    public int solution(Node root) {
        if (root == null)
            return 0;

        int left = solution(root.left);
        int right = solution(root.right);

        // Find the maximum sum from either of the left or right child
        int maxSingle = Math.max(Math.max(left, right) + root.val, root.val);

        // Now find the maximum sum from both the left and right child
        int maxTop = Math.max(maxSingle, left + right + root.val);

        res.val = Math.max(res.val, maxTop);

        return maxSingle;
    }

    /*
    https://www.techiedelight.com/maximum-path-sum-binary-tree/
     */

    public int solution(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int left = solution(root.getLeft());
        int right = solution(root.getRight());

        int max = res.val;
        max = Math.max(max, root.getData());
        max = Math.max(max, root.getData() + left);
        max = Math.max(max, root.getData() + right);
        max = Math.max(max, root.getData() + left + right);

        res.val = max;

        return Math.max(root.getData(), Math.max(left, right) + root.getData());
    }
}

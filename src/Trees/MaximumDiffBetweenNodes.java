package Trees;

/*
https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/?ref=lbp
 */
public class MaximumDiffBetweenNodes {
    int result = 0;
    public int solution(Node root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = solution(root.left);
        int right = solution(root.right);

        int val = Math.min(left, right);

        result = Math.max(result, root.val - val);

        return Math.min(root.val, val);
    }
}

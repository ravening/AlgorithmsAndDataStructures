package Trees;

/*
https://www.geeksforgeeks.org/check-if-removing-an-edge-can-divide-a-binary-tree-in-two-halves/?ref=lbp
 */
public class DivideTreeEqualSize {
    int count = 0;
    Trees.TreeNode<Integer> result;

    private int count(Trees.TreeNode<Integer> root) {
        if (root == null)
            return 0;

        return count(root.getLeft()) + count(root.getRight()) + 1;
    }

    private int solution(Trees.TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int c = solution(root.getLeft()) + 1 + solution(root.getRight());

        if (c == count - c) {
            result = root;
        }

        return c;
    }
}

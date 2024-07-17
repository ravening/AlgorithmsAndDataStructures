package Trees;

/*
https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
 */
public class NumberOfTurnsBetweenNodes {
    public int numberOfTurns(Trees.TreeNode<Integer> root, int a, int b) {
        LCABinaryTree lca = new LCABinaryTree();
        Node lcaNode = lca.lca(a, b);

        if (root == null || (a == b)) {
            return 0;
        }

        if (lcaNode == null) {
            return  -1;
        }

        String s1 = findPath(lcaNode, a, "", "");
        String s2 = findPath(lcaNode, b, "", "");

        int count = 0;

        s1 = new StringBuilder(s1).reverse().toString();
        String result = s1 + s2;

        for (var i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) != result.charAt(i + 1)) {
                count++;
            }
        }

        return count == 0 ? -1 : count;
    }

    public String findPath(Node lca, int x, String tmp, String s1) {
        if (lca == null)
            return "";

        if (lca.val == x) {
            s1 = tmp;
            return s1;
        }

        findPath(lca.left, x, tmp+"l", s1);
        findPath(lca.right, x, tmp + "r", s1);

        return "";
    }
}

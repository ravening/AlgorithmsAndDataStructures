package Trees;

/*
https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
 */
public class BstSubtreeOfTree {
    public int solution(TreeNode<Integer> root) {
        return isBstSubtree(root).ans;
    }

    public NodeInfo isBstSubtree(TreeNode<Integer> node) {
        if (node == null) {
            return new NodeInfo(0, 0, 0, 0, true);
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return new NodeInfo(node.getData(), node.getData(), 1, 1, true);
        }

        NodeInfo left = isBstSubtree(node.getLeft());
        NodeInfo right = isBstSubtree(node.getRight());

        NodeInfo returnNode = new NodeInfo();
        returnNode.size = 1 + left.size + right.size;

        if (left.isBst && right.isBst && (node.getData() > left.max) && (node.getData() < right.min)) {
            returnNode.isBst = true;
            returnNode.ans = returnNode.size;
            returnNode.min = Math.min(node.getData(), Math.min(left.min, right.min));
            returnNode.max = Math.max(node.getData(), Math.max(left.max, right.max));
        } else {
            returnNode.ans = Math.max(left.ans, right.ans);
        }

        return returnNode;
    }
}

class NodeInfo {
    int min;
    int max;
    int size;
    int ans;
    boolean isBst;

    public NodeInfo() {
        isBst = false;
    }

    public NodeInfo(int min, int max, int size, int ans, boolean isBst) {
        this.min = min;
        this.max = max;
        this.size = size;
        this.ans = ans;
        this.isBst = isBst;
    }
}

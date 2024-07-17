package Trees;

/*
https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
 */
public class MinimumTimeToBurnTree {
    Result result = new Result();

    public void solution(TreeNode<Integer> node, Data data, TreeNode<Integer> leafNode) {
        if (node == null)
            return;

        if (node.isLeafNode()) {
            if (node.getData().equals(leafNode.getData())) {
                data.contains = true;
                data.time = 0;
            }
            return;
        }

        Data left = new Data();
        solution(node.getLeft(), left, leafNode);

        Data right = new Data();
        solution(node.getRight(), right, leafNode);

        data.contains = left.contains || right.contains;

        data.time = left.contains ? (1 + left.time) : -1;

        if (data.time == -1) {
            data.time = right.contains ? (1 + right.time) : -1;
        }

        data.leftDepth = (node.getLeft() == null) ? 0 : (1 + Math.max(left.leftDepth, left.rightDepth));
        data.rightDepth = (node.getRight() == null) ? 0 : (1 + Math.max(right.leftDepth, right.rightDepth));

        if (data.contains) {
            if (left.contains) {
                result.result = Math.max(result.result, data.time + data.rightDepth);
            }
            if (right.contains) {
                result.result = Math.max(result.result, data.time + data.leftDepth);
            }
        }
    }
}

class Result {
    int result;
}

class Data {
    boolean contains;
    int time;
    int leftDepth;
    int rightDepth;

    public Data() {
        contains = false;
        time = -1;
    }
}

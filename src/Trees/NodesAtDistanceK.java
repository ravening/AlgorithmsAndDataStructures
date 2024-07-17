package Trees;

/*
https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */
public class NodesAtDistanceK {
    public int printNodesAtDistanceK(Trees.TreeNode<Integer> root, Trees.TreeNode<Integer> target, int K) {
        if (root == null)
            return -1;


        if (root == target) {
            printChildrenAtDistanceK(target, K);
            return 0;
        }

        int left = printNodesAtDistanceK(root.getLeft(), target, K);

        if (left != -1) {
            if (left + 1 == K) {
                System.out.println(root.getData());
            } else {
                printChildrenAtDistanceK(root.getRight(), K - left - 2);
            }

            return 1 + left;
        }

        int right = printNodesAtDistanceK(root.getRight(), target, K);
        if (right != -1) {
            if (right + 1 == K) {
                System.out.println(root.getData());
            } else {
                printChildrenAtDistanceK(root.getLeft(), K - right - 2);
            }
            return 1 + right;
        }

        return -1;
    }

    public void printChildrenAtDistanceK(Trees.TreeNode<Integer> node, int K) {
        if (node == null || K < 0)
            return;

        if (K == 0) {
            System.out.println(node.getData());
        }

        printChildrenAtDistanceK(node.getLeft(), K - 1);
        printChildrenAtDistanceK(node.getRight(), K - 1);
    }
}

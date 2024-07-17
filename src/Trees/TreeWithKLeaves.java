package Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/print-nodes-having-k-leaves/1
 */
public class TreeWithKLeaves {

    static List<Integer> result = new ArrayList<>();
    public static List<Integer> solution(Trees.TreeNode<Integer> root, int k) {
        solutionUtil(root, k);
        return result;
    }

    public static int solutionUtil(Trees.TreeNode<Integer> root, int k) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.isLeafNode()) {
            count++;
        }

        count += solutionUtil(root.getLeft(), k);
        count += solutionUtil(root.getRight(), k);

        if (count == k && (root.getLeft() != null || root.getRight() != null)) {
            result.add(root.getData());
        }

        return count;
    }
}

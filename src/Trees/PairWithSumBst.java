package Trees;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 */
public class PairWithSumBst {
    public static boolean pairWithSum(TreeNode<Integer> root, int target) {
        Stack<TreeNode<Integer>> inorder = new Stack<>();
        Stack<TreeNode<Integer>> reverseInorder = new Stack<>();

        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;

        TreeNode<Integer> curr1 = root, curr2 = root;

        while (true) {
            while (!done1) {
                if (curr1 != null) {
                    inorder.push(curr1);
                    curr1 = curr1.getLeft();
                } else {
                    if (inorder.isEmpty()) {
                        done1 = true;
                    } else {
                        curr1 = inorder.pop();
                        val1 = curr1.getData();
                        curr1 = curr1.getRight();
                        done1 = true;
                    }
                }
            }

            while (!done2) {
                if (curr2 != null) {
                    reverseInorder.push(curr2);
                    curr2 = curr2.getRight();
                } else {
                    if (reverseInorder.isEmpty()) {
                        done2 = true;
                    } else {
                        curr2 = reverseInorder.pop();
                        val2 = curr2.getData();
                        curr2 = curr2.getLeft();
                        done2 = true;
                    }
                }
            }

            if (val1 != val2 && (val1 + val2 == target)) {
                System.out.println(val1 + " " + val2);
                return true;
            }

            if (val1 + val2 < target) {
                done1 = false;
            } else if (val1 + val2 > target) {
                done2 = false;
            } else if (val1 > val2) {
                return false;
            }
        }
    }
}

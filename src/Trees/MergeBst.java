package Trees;

import org.w3c.dom.Node;

public class MergeBst {
    public void solution(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null)
            return;

        if (root1 == null) {
            InorderWithStack.inorder(root2);
            return;
        }

        if (root2 == null) {
            InorderWithStack.inorder(root1);
            return;
        }

        TreeNode<Integer> temp1 = root1, prev1 = null, temp2 = root2, prev2 = null;

        while (temp1.getLeft() != null) {
            prev1 = temp1;
            temp1 = temp1.getLeft();
        }

        while (temp2.getLeft() != null) {
            prev2 = temp2;
            temp2 = temp2.getLeft();
        }

        if (temp1.getData() <= temp2.getData()) {
            System.out.println(temp1.getData());

            if (prev1 == null) {
                solution(root1.getRight(), root2);
            } else {
                prev1.setLeft(temp1.getRight());
                solution(root1, root2);
            }
        } else {
            System.out.println(temp2.getData());

            if (prev2 == null) {
                solution(root1, root2.getRight());
            } else {
                prev2.setLeft(temp2.getRight());
                solution(root1, root2);
            }
        }

    }
}

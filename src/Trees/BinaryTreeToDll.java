// given a binary tree, convert it into doubly linked list
package Trees;


public class BinaryTreeToDll {

    static src.Trees.TreeNode<Integer> prev = null;
    src.Trees.TreeNode<Integer> head;

    // https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
    public void inPlaceBinaryTreeToDll(src.Trees.TreeNode<Integer> root) {
        if (root == null)
            return;

        inPlaceBinaryTreeToDll(root.getLeft());

        if (prev == null) {
            // we have encountered the left most node. so make it as head
            head = root;
        } else {
            root.setLeft(prev);
            prev.setRight(root);
        }

        prev = root;

        inPlaceBinaryTreeToDll(root.getRight());

    }

    public src.Trees.TreeNode<Integer> solution(src.Trees.TreeNode<Integer> root) {
        if (root == null)
            return null;

        solution(root.getRight());

        root.setRight(head);
        if (head != null)
            head.setLeft(root);

        head = root;

        solution(root.getLeft());

        return head;
    }

    // given a binary tree, return the leaves of the tree as a dobuly linked list
    src.Trees.TreeNode<Integer> temp = head;
    public src.Trees.TreeNode<Integer> returnLeaves(src.Trees.TreeNode<Integer> root) {
        if (root.getLeft() == null && root.getRight() == null)
            return null;

        root.setRight(returnLeaves(root.getLeft()));
        if (temp == null) {
            temp = root;
        } else {
            temp.setRight(root);
            root.setLeft(temp);
            temp = root;
        }

        root.setLeft(returnLeaves(root.getRight()));

        return temp;
    }

    //https://www.techiedelight.com/extract-leaves-of-binary-tree-into-doubly-linked-list/
    public src.Trees.TreeNode<Integer> getLeaves(src.Trees.TreeNode<Integer> root, src.Trees.TreeNode<Integer> head) {
        if (root == null)
            return null;

        root.setRight(getLeaves(root.getRight(), head));
        if (isLeaf(root)) {
            root.setRight(head);

            if (head != null) {
                root.setRight(head);
                head.setLeft(root);
                head = root;
            }
            return null;
        }

        root.setLeft(getLeaves(root.getLeft(),head));

        return root;
    }

    private boolean isLeaf(src.Trees.TreeNode<Integer> root) {
        return root.getLeft() == null && root.getRight() == null;
    }
}

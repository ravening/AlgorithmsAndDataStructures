package Trees;

/*
https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 */
public class MorrisTraversal {
    src.Trees.TreeNode<Integer> root;

    MorrisTraversal() {
        root = null;
    }

    public static void main(String[] args) {
        MorrisTraversal traversal = new MorrisTraversal();
        traversal.insert(50);
        traversal.insert(30);
        traversal.insert(20);
        traversal.insert(40);
        traversal.insert(70);
        traversal.insert(60);
        traversal.insert(80);


        traversal.inorderTraversal();
    }

    public void inorderTraversal() {
        if (root == null)
            return;

        src.Trees.TreeNode<Integer> prev;
        src.Trees.TreeNode<Integer> current = root;

        while (current != null) {
            // if the left child is null then we have encountered the left most child
            // display it and move to right child
            if (current.getLeft() == null) {
                this.display(current.getData());
                current = current.getRight();
            } else {
                prev = current.getLeft();
                // now find the inorder predecessor of the current node which is the
                // right most node in the left subtree
                while (prev.getRight() != null && prev.getRight() != current)
                    prev = (prev.getRight());

                // if prev is null then we found the inorder predecessor. point its right
                // inorder successor which is the current node
                if (prev.getRight() == null) {
                    prev.setRight(current);
                    current = current.getLeft();
                } else {
                    // we have already found the inorder successor. so revert the changes made in above
                    // if condition
                    prev.setRight(null);
                    this.display(current.getData());
                    current = current.getRight();
                }
            }
        }
    }

    private void display(int x) {
        try {
            System.out.print(x + " ");
        } catch (Exception c) {}
    }
    public void insert(Integer x) {
        this.root = this.insertTreeNode(this.root, x);
    }

    private src.Trees.TreeNode<Integer> insertTreeNode(src.Trees.TreeNode<Integer> node, Integer x) {
        if (node == null) {
            return new src.Trees.TreeNode<Integer>(x);
        }

        if (x.equals(node.getData()))
            return node;

        if (x.compareTo(node.getData()) < 0) {
            node.setLeft(insertTreeNode(node.getLeft(), x));
        } else {
            node.setRight(insertTreeNode(node.getRight(), x));
        }

        return node;
    }
}

package Trees;// given a binary tree, convert it into threaded binary tree


// solution : Do a reverse inorder traversal with next variable initialized to null
// when you go right dont change "next". before going left, assign current node to next



public class ThreadedBinaryTree {

    // call solution(root, null);
    public void solution(ThreadedNode root, ThreadedNode prev) {
        if (root.right != null) {
            solution(root.right, prev);
        }

        // when there are no more right child, we are at the righmost child of the subtree.
        // Assign next to null
        root.next = prev;

        // Before traversing the left subtree, assign next to current node
        prev = root;

        if (root.left != null) {
            solution(root.left, prev);
        }
    }

    // Function to display the inorder traversal of a threaded binary tree
    public void inorderTraversal(ThreadedNode root) {
        // get the left most node and start traversing from there using the next link
        ThreadedNode tmp = root;
        while (tmp != null) {
            tmp = leftmostNode(root);

            // display the left most node
            System.out.println(tmp.data);

            // get the left most node of right child if its not null
            if (tmp.right != null) {
                tmp = leftmostNode(tmp.right);
            } else {
                tmp = tmp.next;
            }
        }
    }

    public ThreadedNode leftmostNode(ThreadedNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}

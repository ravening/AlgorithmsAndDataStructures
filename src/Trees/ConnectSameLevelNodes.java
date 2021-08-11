// Given a binary tree, connect the nodes at the same level

// Using level order traversal, we connect the current node to next node
// in the queue
package src.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNodes {
    // solution without using the extra space
    // Do a level order traversal and connect the next pointer
    // of the child nodes from the current level before going
    // to the child level
    public void connectNextRight(ThreadedNode root) {
        if (root == null)
            return;

        ThreadedNode tmp = root;

        // first set the next pointer of root
        root.next = null;

        //traverse all the levels
        while (tmp != null) {
            // traverse all the nodes at the current level
            ThreadedNode q = tmp;
            while (q != null) {
                // First connect the next pointer of the left child
                if (q.left != null) {
                    // if right child is not null then its the next of left
                    if (q.right != null) {
                        q.left.next = q.right;
                    } else {
                        q.left = getNext(q);
                    }
                }

                // now connect the right node
                if (q.right != null) {
                    q.right.next = getNext(q);
                }

                //goto next node
                q = q.next;
            }

            // goto next level
            if (tmp.left != null)
                tmp = tmp.left;
            if (tmp.right != null)
                tmp = tmp.right;
            tmp = getNext(tmp);
        }
    }

    public ThreadedNode getNext(ThreadedNode root) {
        if (root == null)
            return  null;

        ThreadedNode tmp = root.next;

        while (tmp != null) {
            if (tmp.left != null)
                return tmp.left;
            if (tmp.right != null)
                return tmp.right;

            tmp = tmp.next;
        }

        return tmp;
    }
    public void solution(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        // add root and null initially
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            //get the first element from the queue
            // if its null then it means we are done with
            // current level. so add null again
            // else point next of current node to the first element in queue
            TreeNode<Integer> tmp = queue.poll();
            if (tmp != null) {
                // point next to first element in queue
                tmp.setRight(queue.peek());

                if (tmp.getLeft() != null)
                    queue.add(tmp.getLeft());
                if (tmp.getRight() != null)
                    queue.add(tmp.getRight());
            } else if (!queue.isEmpty()) {
                // if we encounter null, it means we are done with current level
                // else queue will never be emtpy
                queue.add(null);
            }
        }
    }
}

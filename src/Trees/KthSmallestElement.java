package Trees;

/*
https://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/?ref=lbp
 */
public class KthSmallestElement {
    public int solution(Node root, int k) {
        if (root == null)
            return -1;

        Node cur = root;
        int count = 0;
        while (cur != null) {
            if (cur.left == null) {
                count++;
                if (count == k) {
                    return cur.val;
                }
                cur = cur.right;
            } else {
                Node pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    count++;
                    if (count == k) {
                        return cur.val;
                    }
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return -1;
    }
}

package Trees;

public class ThreadedNode {
    int data;
    Trees.ThreadedNode left;
    Trees.ThreadedNode right;
    Trees.ThreadedNode next; // points to inorder successor

    public ThreadedNode(int data, Trees.ThreadedNode left, Trees.ThreadedNode right, Trees.ThreadedNode next) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

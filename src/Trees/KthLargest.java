package Trees;

/*
https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
 */
public class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        kthLargest.insert(50);
        kthLargest.insert(30);
        kthLargest.insert(20);
        kthLargest.insert(40);
        kthLargest.insert(70);
        kthLargest.insert(60);
        kthLargest.insert(80);

        kthLargest.solution(3);
    }

    src.Trees.TreeNode<Integer> root;

    KthLargest() {
        root = null;
    }

    public void insert(int x) {
        this.root = this.insertNode(root, x);
    }

    private src.Trees.TreeNode<Integer> insertNode(src.Trees.TreeNode<Integer> root, Integer x) {
        if (root == null) {
            root = new src.Trees.TreeNode<Integer>(x);
            return root;
        }

        if (x.equals(root.getData()))
            return root;

        if (x.compareTo(root.getData()) < 0) {
            root.setLeft(this.insertNode(root.getLeft(), x));
        } else {
            root.setRight(this.insertNode(root.getRight(), x));
        }

        return root;
    }

    public void solution(int k) {
        Counter counter = new Counter();
        kthLargest(root, k, counter);
    }

    private void kthLargest(src.Trees.TreeNode<Integer> root, int k, Counter counter) {
        if (root == null || counter.count >= k)
            return;

        kthLargest(root.getRight(), k, counter);

        counter.count++;

        if (counter.count == k) {
            System.out.println(root.getData());
            return;
        }

        kthLargest(root.getLeft(), k , counter);
    }

    private src.Trees.TreeNode<Integer> kthLargestMorris(src.Trees.TreeNode<Integer> root, int k) {
        if (root == null)
            return null;

        src.Trees.TreeNode<Integer> result = null;
        int count = 0;
        while (root != null) {
            if (root.getRight() == null) {
                if (++count == k) {
                    result = root;
                }

                root = root.getLeft();
            } else {
                src.Trees.TreeNode<Integer> successor = root.getRight();

                while (successor.getLeft() != null && successor.getLeft() != root) {
                    successor = successor.getLeft();
                }

                if (successor.getLeft() == null) {
                    successor.setLeft(root);
                    root = root.getRight();
                } else {
                    successor.setLeft(null);
                    if (++count == k) {
                        result = root;
                        root = root.getLeft();
                    }
                }
            }
        }

        return result;
    }
}

class Counter {
    int count;

    Counter() {
        count = 0;
    }
}

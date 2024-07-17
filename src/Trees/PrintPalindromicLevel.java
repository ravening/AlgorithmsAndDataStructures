package Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/print-all-palindromic-levels-of-a-binary-tree/?ref=rp
 */
public class PrintPalindromicLevel {
    public void solution(TreeNode<Integer> root) {
        System.out.println(root.getData());

        List<TreeNode<Integer>> queue = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int index = 0;
            int curSize = queue.size();
            while (index < curSize) {
                TreeNode<Integer> node = queue.remove(0);
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                index++;
            }
            if (isPalindromeLevel(queue)) {
                printLevel(queue);
            }
        }
    }

    public boolean isPalindromeLevel(List<TreeNode<Integer>> queue) {
        int start = 0;
        int end = queue.size() - 1;

        while (start < end) {
            if (queue.get(start++) != queue.get(end--)) {
                return false;
            }
        }

        return true;
    }

    public void printLevel(List<TreeNode<Integer>> queue) {
        queue.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}

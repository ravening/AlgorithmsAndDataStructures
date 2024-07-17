package Trees;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/?ref=lbp
 */
public class InOrderPostOrder {

    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;

    public void build(int[] inOrder, int[] postOrder) {
        for (var i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        index = inOrder.length;


    }

    public Trees.TreeNode<Integer> buildUtil(int[] inOrder, int[] postOrder, int start, int end) {
        if (start > end)
            return null;

        Trees.TreeNode<Integer> node = new TreeNode<Integer>(postOrder[index]);

        if (start == end) {
            return node;
        }

        int inIndex = map.get(postOrder[index]);
        index--;

        node.setRight(buildUtil(inOrder, postOrder, inIndex + 1, end));
        node.setLeft(buildUtil(inOrder, postOrder, start, inIndex - 1));

        return node;
    }
}

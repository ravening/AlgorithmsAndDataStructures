package Trees;

import Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
https://www.techiedelight.com/construct-binary-tree-from-inorder-level-order-traversals/
 */
public class InorderLevelorder {

    public void solution(int[] inorder, int[] levelOrder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (var i =0; i < levelOrder.length; i++) {
            map.put(levelOrder[i], i);
        }

        build(inorder, 0, inorder.length -1, levelOrder, map);
    }

    public Trees.TreeNode<Integer> build(int[] inorder, int start, int end, int[] levelOrder, Map<Integer, Integer> map) {
        if (start > end) {
            return  null;
        }

        int index = start;

        for (var j = start + 1; j <= end; j++) {
            if (map.get(inorder[j]) < map.get(inorder[index])) {
                index = j;
            }
        }
        Trees.TreeNode<Integer> node = new TreeNode<Integer>(inorder[index]);

        if (start == end) {
            return node;
        }

        node.setLeft(build(inorder, start, index - 1, levelOrder, map));
        node.setRight(build(inorder, index + 1, end, levelOrder, map));

        return node;
    }
}

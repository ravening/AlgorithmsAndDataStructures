package Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/reverse-tree-path/?ref=lbp
 */
public class ReverseTreePath {
    List<src.Trees.TreeNode<Integer>> list = new ArrayList<>();

    public void solution(src.Trees.TreeNode<Integer> root, int x) {
        if (root == null)
            return;

        list.add(root);

        if (root.getData() == x) {
            int i = 0, j = list.size();
            while (i < j) {
                int tmp = list.get(j).getData();
                list.get(j).setData(list.get(i).getData());
                list.get(i).setData(tmp);
                i++;
                j--;
            }
        }

        solution(root.getLeft(), x);
        solution(root.getRight(), x);

        list.remove(list.size() - 1);
    }
}

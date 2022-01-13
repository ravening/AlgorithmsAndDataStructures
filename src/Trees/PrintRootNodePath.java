package Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
 */
public class PrintRootNodePath {
    public void solution(src.Trees.TreeNode<Integer> root, int x) {
        List<Integer> array = new ArrayList<>();
        if (hasPath(root, x, array)){
            array.forEach(y -> System.out.print(y + " "));
        } else {
            System.out.println("No path found");
        }
    }

    public boolean hasPath(src.Trees.TreeNode<Integer> root, int x, List<Integer> array) {
        if (root == null)
            return false;

        array.add(root.getData());

        if (root.getData() == x) {
            return true;
        }

        if (hasPath(root.getLeft(), x, array) || hasPath(root.getRight(), x, array))
            return true;

        array.remove(array.size() - 1);

        return false;
    }
}

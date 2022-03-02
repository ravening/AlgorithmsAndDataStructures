package Trees;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue
 */

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    static String delimiter = ",";
    static String nullValue = "N";

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(nullValue).append(delimiter);
            return sb.toString();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tmp = queue.remove();
            if (tmp == null) {
                sb.append(nullValue).append(delimiter);
            } else {
                sb.append(tmp.val).append(delimiter);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }

        return sb.toString();
    }

    public Node deserialize(String data) {
        Node root = null;
        if (data == null || data.isEmpty())
            return root;

        String[] array = data.split(delimiter);
        if (array.length > 0) {
            Queue<Node> queue = new LinkedList<>();
            root = new Node(Integer.parseInt(array[0]), null, null);
            queue.add(root);
            for (var i = 1; i < array.length; i++) {
                Node parent = queue.remove();
                if (!array[i].equalsIgnoreCase(nullValue)) {
                    Node left = new Node(Integer.parseInt(array[i++]), null, null);
                    parent.left = left;
                    queue.add(left);
                }
                if (!array[i].equalsIgnoreCase(nullValue)) {
                    Node right = new Node(Integer.parseInt(array[i]), null, null);
                    parent.right = right;
                    queue.add(right);
                }
            }
        }

        return root;
    }
}

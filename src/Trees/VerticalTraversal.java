package Trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node newNode(int val) {
            Node node = new Node();
            node.data = val;
            node.left = node.right = null;
            return node;
        }
        Node() {}
    }

    static class QueueObject {
        int level;
        Node node;

        QueueObject(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    Map<Integer, List<Node>> treeMap = new TreeMap<>();

    Map<Integer, List<Node>> reverseTreeMap = new TreeMap<>(Comparator.reverseOrder());

    public void verticalTraversal(Node root) {
        if (root == null)
            return;

        Queue<QueueObject> queue = new LinkedList<>();
        QueueObject queuObject = new QueueObject(0, root);
        queue.offer(queuObject);

        while (!queue.isEmpty()) {
            QueueObject object = queue.poll();
            int level = object.level;
            Node tmp = object.node;

            if (treeMap.containsKey(level)) {
                treeMap.get(level).add(tmp);
                reverseTreeMap.get(level).add(tmp);
            } else {
                List<Node> nodeList = new ArrayList<>();
                nodeList.add(tmp);
                treeMap.put(level, nodeList);
                reverseTreeMap.put(level, nodeList);
            }

            if (tmp.left != null) {
                queue.offer(new QueueObject(level - 1, tmp.left));
            }
            if (tmp.right != null) {
                queue.offer(new QueueObject(level + 1, tmp.right));
            }
        }

        displayTree(treeMap);

        System.out.println("===============");
        System.out.println("Reverse vertical order traversal is ");
        displayTree(reverseTreeMap);
    }

    private void displayTree(Map<Integer, List<Node>> map) {
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            List<Node> nodeList = entry.getValue();
            nodeList.forEach(x -> System.out.print(x.data + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node n = new Node();
        Node root;
        root = n.newNode(1);
        root.left = n.newNode(2);
        root.right = n.newNode(3);
        root.left.left = n.newNode(4);
        root.left.right = n.newNode(5);
        root.right.left = n.newNode(6);
        root.right.right = n.newNode(7);
        root.right.left.right = n.newNode(8);
        root.right.right.right = n.newNode(9);
        root.right.right.left = n.newNode(10);
        root.right.right.left.right = n.newNode(11);
        root.right.right.left.right.right = n.newNode(12);

        VerticalTraversal verticalTraversal = new VerticalTraversal();
        verticalTraversal.verticalTraversal(root);
    }
}

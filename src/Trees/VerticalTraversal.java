package Trees;

import java.util.*;

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

    static class ListNode {
        List<Integer> data = new ArrayList<>();
        ListNode prev;
        ListNode next;

        ListNode(ListNode p, ListNode n) {
            this.prev = p;
            this.next = n;
        }
    }

    static class Pair<U, V> {
        U treeNode;
        V listNode;

        Pair(U u, V v) {
            this.treeNode = u;
            this.listNode = v;
        }
    }

    /*
    https://www.techiedelight.com/print-nodes-binary-tree-vertical-order/`
     */
    public void solution(Node root) {
        ListNode head = new ListNode(null, null);
        verticalTraversalDll(root, head);
        print(head);
    }

    public void verticalTraversalDll(Node root, ListNode head) {
        if (root == null)
            return;

        Queue<Pair<Node, ListNode>> queue = new ArrayDeque<>();

        queue.add(new Pair<>(root, head));

        while (!queue.isEmpty()) {
            Pair<Node, ListNode> tmp = queue.poll();
            Node node = tmp.treeNode;
            ListNode listNode = tmp.listNode;

            listNode.data.add(node.data);

            if (node.left != null) {
                if (listNode.prev == null) {
                    listNode.prev = new ListNode(null, listNode);
                }

                queue.add(new Pair<>(node.left, listNode.prev));
            }

            if (node.right != null) {
                if (listNode.next == null) {
                    listNode.next = new ListNode(listNode, null);
                }

                queue.add(new Pair<>(node.right, listNode.next));
            }
        }
    }

    public void print(ListNode node) {
        ListNode head = null;

        while (node != null && node.prev != null) {
            node = node.prev;
        }

        head = node;

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
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
        System.out.println("======================");
        verticalTraversal.solution(root);
    }
}

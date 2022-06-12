package Trees;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/binary-tree-string-brackets/
 */
public class TreeToString {

    static String tree = "";

    public void treeToString(Node node) {
        if (node == null) {
            return;
        }

        tree += String.valueOf(node.val);

        if (node.left == null && node.right == null) {
            return;
        }

        tree += '(';
        treeToString(node.left);
        tree += ')';

        if (node.right != null) {
            tree += '(';
            treeToString(node.right);
            tree += ')';
        }
    }

    public Node stringToTree(String s) {
        if (s == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();

        for (var i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;

                while (i < s.length() && Character.isDigit(s.charAt(i+1))) {
                    i++;
                }
                int val = Integer.parseInt(s.substring(j, i));
                Node node = new Node(val);

                if (stack.isEmpty()) {
                    stack.push(node);
                } else {
                    Node parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                    stack.push(node);
                }

            }
            if (s.charAt(i) == ')') {
                stack.pop();
            }
        }

        return stack.pop();
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.val);
            return;
        }

        System.out.print(root.val);
        System.out.print("(");
        preorder(root.left);
        System.out.print(")");
        System.out.print("(");
        preorder(root.right);
        System.out.print(")");
    }
    public static void main(String[] args) {
        Node root = new Node(1, null, null);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        TreeToString treeToString = new TreeToString();
        treeToString.treeToString(root);
        System.out.println(tree);
        treeToString.preorder(root);

        Node newNode = treeToString.stringToTree(tree);
        treeToString.preorder(newNode);
    }
}

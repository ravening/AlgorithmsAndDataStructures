package Trees;

import java.util.Stack;

/*
https://www.techiedelight.com/expression-tree/
 */
public class ExpressionTree {
    public static TreeNode<Character> solution(String postfix) {
        Stack<TreeNode<Character>> stack = new Stack<>();

        for (Character ch : postfix.toCharArray()) {
            if (isOperator(ch)) {
                TreeNode<Character> right = stack.pop();
                TreeNode<Character> left = stack.pop();

                TreeNode<Character> root = new TreeNode<>(ch, left, right);
                stack.push(root);
            } else {
                stack.push(new TreeNode<>(ch));
            }
        }

        return stack.peek();
    }

    private static boolean isOperator(Character character) {
        return (character == '+' || character == '-' || character == '*' || character == '/' || character == '^');
    }
}

package Strings;

import java.util.Arrays;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/find-a-valid-parenthesis-sequence-of-length-k-from-a-given-valid-parenthesis-sequence/?ref=rp
 */
public class FindParanthesisString {

    String s;
    Stack<Integer> stack;
    int length;

    FindParanthesisString(String s, int x) {
        this.s = s;
        stack = new Stack<>();
        length = x;
    }

    private String solution() {
        StringBuilder sb = new StringBuilder();
        boolean []visited = new boolean[s.length()];
        Arrays.fill(visited, false);

        int count = 0;
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            if (count < length && s.charAt(i) == ')') {
                visited[stack.peek()] = true;
                stack.pop();
                visited[i] = true;
                count += 2;
            }
        }

        for (var i = 0; i < s.length(); i++) {
            if (visited[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FindParanthesisString string =
                new FindParanthesisString("()(())", 4);

        System.out.println(string.solution());
    }
}

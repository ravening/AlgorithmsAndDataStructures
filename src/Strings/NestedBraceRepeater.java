package Strings;

import java.util.Stack;

public class NestedBraceRepeater {

    public static String processString(String input) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        Stack<Integer> countStack = new Stack<>();
        int number = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '{') {
                countStack.push(number);
                stack.push(new StringBuilder());
                number = 0;
            } else if (c == '}') {
                String repeatedString = stack.pop().toString();
                StringBuilder temp = new StringBuilder();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(repeatedString);
                }
                stack.peek().append(temp);
            } else {
                stack.peek().append(c);
            }
        }

        return stack.pop().toString();
    }

    public static void main(String[] args) {
        String input1 = "3{a}2{4{b}}";
        System.out.println(processString(input1));  // Output: aaabbbbbbbb

        String input2 = "2{3{b}2{c}}";
        System.out.println(processString(input2));  // Output: bbbccbbbcc
    }
}

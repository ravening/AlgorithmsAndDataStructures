package Strings;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/discuss/interview-question/1743968/Facebook-or-Phonescreen-or-SDE
 */
public class AddOrSubtract {
    public String solution(String string) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        if (string == null) {
            return "";
        }

        for (var i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == 'a') {
                i += 3;
                stack.add("add");
            } else if (ch == 's') {
                i += 8;
                stack.add("subtract");
            } else if (Character.isDigit(ch)){
                int num = 0;

                while (i < string.length() && Character.isDigit(ch)) {
                    num = num * 10 + ch - '0';
                    i++;
                }
                stack.add(String.valueOf(num));
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    int second = Integer.parseInt(stack.pollLast());
                    int first = Integer.parseInt(stack.pollLast());

                    int sum = 0;
                    if (stack.pollLast().equals("add")) {
                        sum = first + second;
                    } else {
                        sum = first - second;
                    }
                    stack.push(String.valueOf(sum));
                }
            }
        }

        return stack.pop();
    }
}

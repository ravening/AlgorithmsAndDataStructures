package Strings;

import java.util.Stack;

public class LeetCode394 {
    public String decodeString(String s) {
        Stack<Pair> stack = new Stack<>();
        String currentString = "";
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                Pair pair = new Pair(k, currentString);
                stack.push(pair);
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                Pair pair = stack.pop();
                currentString = pair.s + currentString.repeat(pair.count);
                System.out.println("result is " + currentString);
            } else if (Character.isDigit(ch)) {
                k = k * 10 + Integer.valueOf(ch - '0');
                System.out.println("k is " + k);
            } else {
                currentString += ch;
            }
        }
        
        return currentString;
    }
    
    static class Pair {
        int count;
        String s;
        
        Pair(int c, String str) {
            this.count = c;
            this.s = str;
        }
    }

    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
        System.out.println(leetCode394.decodeString("3[a2[c]]"));
    }
}

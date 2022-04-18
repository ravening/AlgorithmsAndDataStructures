package Strings;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class LeetCode726 {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        int n = formula.length();
        int i = 0, val = 0;
        Map<String, Integer> map = new TreeMap<>();
        while (i < n) {
            char ch = formula.charAt(i);
            i++;

            if (ch == '(') {
                stack.add(map);
                map = new TreeMap<>();
            } else if (ch == ')') {
                Map<String, Integer> top = map;
                map = stack.pop();
                val = 0;

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + Integer.valueOf(formula.charAt(i) - '0');
                    i++;
                }
                val = val == 0 ? 1 : val;
                for (String key : top.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + top.getOrDefault(key, 0) * val);
                }
            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String symbol = formula.substring(start, i);
                val = 0;

                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    char c = formula.charAt(i);
                    val = val * 10 + Integer.valueOf(c - '0');
                    i++;
                }

                val = val == 0 ? 1 : val;
                map.put(symbol, map.getOrDefault(symbol, 0) + val);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) {
                sb.append(map.get(key));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode726 leetCode726 = new LeetCode726();
        System.out.println(leetCode726.countOfAtoms("Mg(OH)2"));
    }
}

package Strings;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ValidParanthesis {
    Map<Character, Character> map = new HashMap<>();

    public boolean isValid(String string) {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Queue<Character> stack = new ArrayDeque<>();

        Queue<String> queue = new ArrayDeque<>();
        for (var i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (map.containsKey(ch)) {
                stack.add(map.get(ch));
            } else if (! stack.peek().equals(map.get(ch))) {
                return false;
            } else {
                stack.poll();
            }
        }

        return stack.isEmpty();
    }
}

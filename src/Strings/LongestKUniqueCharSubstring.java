package Strings;

import java.util.HashMap;
import java.util.Map;

/*
https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */
public class LongestKUniqueCharSubstring {
    public static void solution(String s, int K) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int result = 0;
        for (var i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() == K) {
                result = Math.max(result, (i- start + 1));
            }

            while (map.size() > K && start <= i) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                map.remove(s.charAt(start), 0);
                start++;
            }
        }

        if (result == 0) {
            System.out.println("No solution");
        } else {
            System.out.println(s.substring(start, start + result));
        }
    }

    public static void main(String[] args) {
        String string = "aabacbebebe";
        solution(string, 3);
    }
}

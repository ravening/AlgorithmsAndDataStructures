package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)
 */
public class LeetCode30 {

    public static List<Integer> solution(String string, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        int wordsLength = words.length * words[0].length();
        int length = words[0].length();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> seen = new HashMap<>();

        for (var i = 0; i < string.length() - wordsLength + 1; i++) {
            int j = 0;
            for (j = 0; j < words.length; j++) {
                String s = string.substring(i + j * length, i + (j + 1) * length);
                if (count.containsKey(s)) {
                    seen.put(s, seen.getOrDefault(s, 0) + 1);
                    if (seen.get(s) > 1) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == words.length) {
                result.add(i);
            }
            seen.clear();
        }

        return result;
    }
}

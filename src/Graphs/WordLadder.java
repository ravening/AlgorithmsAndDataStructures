package Graphs;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 */
public class WordLadder {
    public static int solution(String begin, String end, Set<String> dictionary) {
        if (!dictionary.contains(end))
            return 0;

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), tmp = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(begin);
        endSet.add(end);
        int length = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            for (String word : beginSet) {
                char[] array = word.toCharArray();
                for (var i = 0; i < array.length; i++) {
                    for (var ch = 'a'; ch <= 'z'; ch++) {
                        char old = array[i];
                        array[i] = ch;

                        String s = String.valueOf(array);

                        if (endSet.contains(s)) {
                            return length + 1;
                        }

                        if (!visited.contains(s) && dictionary.contains(s)) {
                            tmp.add(s);
                            visited.add(s);
                        }
                    }
                }
            }

            beginSet = tmp;
            tmp.clear();
            length++;
        }

        return length;
    }
}

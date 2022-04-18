package Strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = 1;
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();

        Set<String> visited = new HashSet<>();

        begin.add(beginWord);
        end.add(endWord);

        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> tmp = begin;
                begin = end;
                end = tmp;
            }

            Set<String> tmp = new HashSet<>();

            for (var word : begin) {
                char[] array = word.toCharArray();
                for (var i = 0; i < array.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char tmpChar = array[i];
                        array[i] = c;
                        String result = String.valueOf(array);

                        if (end.contains(result)) {
                            return len + 1;
                        }

                        if (!visited.contains(result) && wordList.contains(result)) {
                            tmp.add(result);
                            visited.add(result);
                        }
                        array[i] = tmpChar;
                    }
                }
            }

            begin = tmp;
            len++;
        }

        return 0;
    }
}

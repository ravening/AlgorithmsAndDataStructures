package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set  = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (var i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                for (var j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] array = word.toCharArray();
                        array[j] = c;

                        String tmp = new String(array);

                        if (set.contains(tmp) && !visited.contains(tmp)) {
                            queue.offer(tmp);
                            visited.add(tmp);
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        LC127 lc127 = new LC127();
        System.out.println(lc127.ladderLength(beginWord, endWord, wordList));
    }
}

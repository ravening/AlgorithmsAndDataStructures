package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/solutions/40434/c-solution-using-standard-bfs-method-no-dfs-or-backtracking/
 */
public class LC126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(Arrays.asList(beginWord));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                List<String> cur = queue.poll();
                String lastWord = cur.get(cur.size() - 1);
                List<String> neighbours = bfs(lastWord, wordSet);

                for (String neighbour : neighbours) {
                    List<String> newList = new ArrayList<>(cur);
                    newList.add(neighbour);
                    visited.add(neighbour);

                    if (endWord.equals(neighbour)) {
                        res.add(newList);
                    } else {
                        queue.offer(newList);
                    }
                }
            }

            for (String s : visited) {
                wordSet.remove(s);
            }
        }

        return res;
    }

    public List<String> bfs(String s, Set<String> wordSet) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();

            for (char c = 'a'; c < 'z'; c++) {
                chars[i] = c;
                String word = new String(chars);
                if (wordSet.contains(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}

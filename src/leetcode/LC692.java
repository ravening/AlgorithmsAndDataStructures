package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-words/solutions/431008/summary-of-all-the-methods-you-can-imagine-of-this-problem/
 */
public class LC692 {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        LC692 lc692 = new LC692();
        System.out.println(lc692.topKFrequent(words, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Trie[] array = new Trie[words.length];

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int frequency = entry.getValue();

            if (array[frequency] == null) {
                array[frequency] = new Trie();
            }

            array[frequency].insert(key);
        }

        List<String> result = new ArrayList<>();

        for (var i = words.length - 1; i >= 0; i--) {
            if (array[i] != null) {
                List<String> temp = new ArrayList<>();

                array[i].getWords(array[i].root, temp);
                if (temp.size() < k) {
                    result.addAll(temp);
                    k = k - temp.size();
                } else {
                    for (var j = 0; j < k; j++) {
                        result.add(temp.get(j));
                    }
                    break;
                }
            }
        }

        return result;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }

    public void getWords(TrieNode root, List<String> words) {
        if (root == null) {
            return;
        }

        if (root.word != null) {
            words.add(root.word);
        }

        for (var i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], words);
            }
        }
    }
}

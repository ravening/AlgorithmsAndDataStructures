package src.Tries;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/strings-from-an-array-which-are-not-prefix-of-any-other-string/
 */
public class PrefixString {
    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        TrieImpl.TrieNode root = trie.getRoot();
        String keys[] = { "apple", "app", "there", "the", "like" };
        PrefixString prefixString = new PrefixString();
        for (String s : keys) {
            prefixString.insertWord(root, s);
        }

        List<String> words = new ArrayList<>();
        trie.getWords(root, words);
        words.forEach(System.out::println);
    }


    public void insertWord(TrieImpl.TrieNode root, String s) {
        char[] ch = s.toCharArray();
        TrieImpl.TrieNode head = root;

        for (var c : ch) {
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new TrieImpl.TrieNode();
            }
            head.isLeaf = false;
            head = head.children[c - 'a'];
        }
        int i;

        for (i = 0; i < 26; i++) {
            if (head.children[i] != null) {
                return;
            }
        }

        if (i == 26) {
            head.isLeaf = true;
            head.word = s;
        }
    }
}

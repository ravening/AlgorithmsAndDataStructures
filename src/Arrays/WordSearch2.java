package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 */
public class WordSearch2 {

    static class TrieNode {
        String word;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public List<String> searchWords(char[][] board, List<String> words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        buildTrie(words, root);

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                dfs(board, root, result, i, j);
            }
        }
        return result;
    }

    private void buildTrie(List<String> words, TrieNode root) {
        for (String str : words) {
            TrieNode cur = root;

            for (var ch : str.toCharArray()) {
                int pos = ch - 'a';
                if (cur.children[pos] == null)
                    cur.children[pos] = new TrieNode();

                cur = cur.children[pos];
            }

            cur.word = str;
        }
    }

    private void dfs(char[][] board, TrieNode root, List<String> result, int x, int y) {
        char ch = board[x][y];

        if (ch == '#' || root.children[ch - 'a'] == null)
            return;
        root = root.children[ch - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
            return;
        }

        board[x][y] = '#';

        if (x > 0) dfs(board, root, result, x - 1, y);
        if (y > 0) dfs(board, root,result, x, y - 1);
        if (x < board.length - 1) dfs(board, root, result, x+1, y);
        if (y < board[0].length) dfs(board, root, result, x, y + 1);

        board[x][y] = ch;
    }
}


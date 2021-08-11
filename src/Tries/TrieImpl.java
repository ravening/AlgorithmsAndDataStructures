package src.Tries;// program to add and search a word in the trie


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieImpl {
    static class TrieNode {
        String word;
        boolean isLeaf;
        TrieNode[] children;

        public TrieNode(String word, boolean isLeaf, TrieNode[] children) {
            this.word = word;
            this.isLeaf = isLeaf;
            this.children = children;
        }

        public TrieNode() {
            this.children = new TrieNode[26];
            Arrays.fill(this.children, null);
            this.word = "";
            this.isLeaf = false;
        }

    }

    TrieImpl() {
        root = new TrieNode();
    }
    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    // program to add a word in the trie
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode head = root;
        for (char ch : chars) {
            if (head.children[ch - 'a'] == null) {
                head.children[ch - 'a'] = new TrieNode();
            }

            head = head.children[ch -'a'];
        }
        head.isLeaf = true;
        head.word = word;
    }

    public boolean searchWord(String word) {
        return match(word.toCharArray(), 0 , root);
    }

    public boolean match(char[] chars, int k, TrieNode head) {
        if (k == chars.length) {
            return (head.isLeaf == true && head.word.equals(new String(chars)));
        }

        if (chars[k] != '.') {
            if (head.children[chars[k] - 'a'] != null) {
                return match(chars, k+1, head.children[chars[k] - 'a']);
            }
        } else {
            // . can match any character. so iterate for all the children nodes
            for (int i = 0; i < 26; i++ ) {
                if (head.children[i] != null) {
                    if (match(chars, k+1, head.children[i])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    protected List<String> getWords(TrieNode head) {
        List<String> words = new ArrayList<>();

        if (head.isLeaf) {
            words.add(head.word);
        }

        for (int i = 0; i < 26; i ++) {
            if (head.children[i] != null) {
                words.addAll(getWords(head.children[i]));
            }
        }

        return words;
    }

    protected void getWords(TrieNode root, List<String> words) {
        if (root.isLeaf) {
            words.add(root.word);
            return;
        }

        for (var i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], words);
            }
        }
    }

    public List<String> autoComplete(String prefix) {
        TrieNode head = root;
        char[] chars = prefix.toCharArray();

        for (int i = 0; i < prefix.length(); i++) {
            if (head.children[chars[i] - 'a'] == null) {
                return new ArrayList<>();
            }
            head = head.children[chars[i] - 'a'];
        }

        return getWords(head);
    }

    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        List<String> words = List.of("amazon", "amazonprime", "amazing", "amazingspiderman", "amazed", "alibaba", "alibabaexpress", "ebay", "walmart");
        words.forEach(w -> trie.addWord(w));
        List<String> autocomplete = trie.autoComplete("ali");

        autocomplete.forEach(System.out::println);
    }
}

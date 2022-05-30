package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://www.geeksforgeeks.org/word-break-problem-dp-32/
public class WordBreak {
    private TrieNode root;
    private Set<String> dictionary;

    WordBreak() {
        root = new TrieNode();
        dictionary = new HashSet<>();
    }

    public static void solution(String s, List<String> dictionary) {
        if (s == null || s.isEmpty())
            return;

        if (dictionary.isEmpty())
            return;

        int i = 0, j = 1;
        List<String> answer = new ArrayList<>();
        int count = 0;

        while (j <= s.length()) {
            if (dictionary.contains(s.substring(i, j))) {
                answer.add(s.substring(i, j));
                count += j - i;
                i = j;
                j++;
            } else {
                j++;
            }
        }

        if (count == s.length()) {
            answer.forEach(x -> System.out.print(x + " "));
        }
    }

    private boolean searchWord(String s) {
        TrieNode head = root;

        for (Character ch : s.toCharArray()) {
            if (!head.child.containsKey(ch))
                return false;

            head = head.child.get(ch);
        }

        return head.isLeaf;
    }

    private void addWord(String s) {
        TrieNode head = root;

        for (char ch : s.toCharArray()) {
            head.child.computeIfAbsent(ch, TrieNode::new);

            head = head.child.get(ch);
        }
        head.isLeaf = true;
    }

    public void insertWords(List<String> words) {
        if (words == null || words.isEmpty())
            return;

        words.forEach(this::addWord);
    }

    private boolean wordBreak(String s) {
        int size = s.length();

        if (size == 0) {
            return true;
        }

        for (int i = 1; i <= size; i++) {
            if (searchWord(s.substring(0, i)) && wordBreak(s.substring(i, size))) {
                return true;
            }
        }

        return false;
    }
    public void wordBreak(String s, List<String> words) {
        this.insertWords(words);
        dictionary.addAll(words);
        System.out.println(wordBreak(s));
        System.out.println();
        wordBreakUtil(s, "");
    }



    /*
    https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
     */
    /*
    Function to display all possible sentences
     */
    public void wordBreakUtil(String s, String prefix) {

        for (var i = 1; i <= s.length(); i++) {
            if (this.dictionary.contains(s.substring(0, i))) {
                if (i == s.length()) {
                    prefix = prefix + s.substring(0, i);
                    System.out.println(prefix);
                } else {
                    wordBreakUtil(s.substring(i), prefix + s.substring(0, i) + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>(Arrays.asList(
                "mobile", "samsung", "sam", "man", "mango", "icecream", "and", "i", "like", "ice", "cream", "go", "love", "sung"
        ));

        String word = "ilikemango";
//        solution(word, dictionary);

        WordBreak wordBreak = new WordBreak();

        wordBreak.wordBreak(word, dictionary);
        word = "ilikeicecreamandmango";
        wordBreak.wordBreak(word, dictionary);
        word = "ilovesamsungmobile";
        wordBreak.wordBreak(word, dictionary);

        String s = "wordlength";
        System.out.println(s.substring(s.length()));
    }


}

class TrieNode {
    Map<Character, TrieNode> child;
    boolean isLeaf;

    public TrieNode(Map<Character, TrieNode> child, boolean isLeaf) {
        this.child = child;
        this.isLeaf = isLeaf;
    }

    public TrieNode() {
        child = new HashMap<>();
        isLeaf = false;
    }

    public TrieNode(Character character) {
        child = new HashMap<>();
        isLeaf = false;
    }

    public TrieNode getNode(Character ch) {
        TrieNode node = new TrieNode();
        return node;
    }
}

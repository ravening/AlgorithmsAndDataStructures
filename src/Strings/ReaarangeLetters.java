// given a string, arrange the letters such that no two characters are adjacent

package Strings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReaarangeLetters {
    public static class Node {
        Character character;
        int count;

        public Node(Character character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    Comparator<Node> comparator = (o1, o2) -> {return -(o1.count - o2.count);};
    public void solution(String string) {
        PriorityQueue<Node> pq= new PriorityQueue<>(comparator);
        //get character count
        char[] count = new char[26];
        for (char ch : string.toCharArray()) {
            count[ch - 'a']++;

        }

        // add characters with frequencies to pq
        for (char ch = 'a'; ch < 'z'; ch++) {
            if (count[ch - 'a'] > 0) {
                int c = count[ch - 'a'];
                Node node = new Node(ch, c);
                pq.add(node);
            }
        }

        Node prev = new Node('#', -1);
        String tmp = "";

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            tmp += temp.character;
            temp.count--;

            if (prev.count > 0) {
                pq.add(prev);
            }

            prev = temp;
        }

        if (tmp.length() == string.length()) {
            System.out.println(tmp);
        } else {
            System.out.println("NO valid string");
        }
    }

    public static void main(String[] args) {
        ReaarangeLetters reaarangeLetters = new ReaarangeLetters();
        reaarangeLetters.solution("aaabbccf");
    }
}

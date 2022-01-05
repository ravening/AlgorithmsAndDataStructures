package Strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/?ref=lbp
 */
public class NonRepeatingCharacter {
    public static void solution(String string) {
        List<Character> list = new LinkedList<>();
        boolean[] repeated = new boolean[256];

        for (var ch : string.toCharArray()) {
            if (!repeated[ch]) {
                if (!list.contains(ch)) {
                    list.add(ch);
                } else {
                    list.remove(ch);
                    repeated[ch] = true;
                }
            }

            if (!list.isEmpty())
                System.out.println("First non repeated char is " + list.get(0));
        }
    }

    public static void anotherSolution(String string) {
        int[] count = new int[26];
        Queue<Character> queue = new LinkedList<>();

        Arrays.fill(count, 0);

        for (var i = 0; i < string.length(); i++) {
            queue.add(string.charAt(i));
            count[string.charAt(i) - 'a']++;

            while (!queue.isEmpty()) {
                if (count[queue.peek() - 'a'] > 1) {
                    queue.remove();
                } else {
                    System.out.print(queue.peek() + " ");
                    break;
                }
            }

            if (queue.isEmpty())
                System.out.print("-1 ");
        }
    }
}

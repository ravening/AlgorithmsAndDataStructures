package Strings;

import java.util.HashSet;
import java.util.Set;

/*
https://www.techiedelight.com/find-number-of-customers-who-could-not-get-any-computer/
 */
public class ComputerCafe {
    public static int solution(String s, int capacity) {
        if (s == null || s.isEmpty())
            return 0;

        Set<Character> visited = new HashSet<>();
        Set<Character> allocated = new HashSet<>();
        int unattended = 0;
        for (char ch : s.toCharArray()) {
            if (!visited.contains(ch)) {
                visited.add(ch);
                if (allocated.size() < capacity) {
                    allocated.add(ch);
                } else {
                    unattended++;
                }
            } else {
                visited.remove(ch);
                allocated.remove(ch);
            }
        }

        return unattended;
    }

    public static void main(String[] args) {
        String s = "ABCDDCEFFEBGAG";
        System.out.println(solution(s, 3));

        s = "ABCDDCBEFFEGAG";
        System.out.println(solution(s, 2));
    }
}

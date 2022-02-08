package Strings;

import java.util.HashSet;
import java.util.Set;

public class SubstringWithKDistinctChars {
    public static Set<String> solution(String s, int k) {
        Set<String> result = new HashSet<>();

        if (s.length() < k)
            return result;

        Set<Character> characters = new HashSet<>();
        for (var i = 0; i < s.length() - k + 1; i++) {
            characters.clear();
            for (var j = i; j < s.length() && characters.size() <= k; j++) {
                characters.add(s.charAt(j));

                if (characters.size() == k) {
                    result.add(s.substring(i, j+1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "abcadce";
        int k = 4;
        Set<String> output = solution(str, k);
        output.forEach(System.out::println);
    }
}

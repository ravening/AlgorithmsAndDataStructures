package Strings;

import java.util.HashSet;
import java.util.Set;

public class StringsDifferBy1Char {
    public boolean solution(String[] words) {
        if (words == null || words.length < 2) {
            return false;
        }

        Set<String> set = new HashSet<>();

        for (var i = 0; i < words[0].length(); i++) {
            set.clear();
            for (String word : words) {
                String tmp = word.substring(0, i) + word.substring(i + 1);
                if (!set.add(tmp)) {
                    return true;
                }
            }
        }

        return false;
    }
}

package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 */
public class FirstNonRepeatedCharInStream {
    public String solution(String stream) {
        if (stream == null || stream.isEmpty())
            return "";

        List<Character> list = new ArrayList<>();
        boolean[] repeated = new boolean[265];

        Arrays.fill(repeated, false);

        for (var i = 0; i < stream.length(); i++) {
            Character x = stream.charAt(i);

            if (!repeated[x]) {
                if (!list.contains(x)) {
                    list.add(x);
                } else {
                    list.remove(x);
                    repeated[x] = true;
                }
            }
        }

        return list.size() > 0 ? list.get(0).toString() : "";
    }
}

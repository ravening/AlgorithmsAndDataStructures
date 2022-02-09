package Strings;

import java.util.HashMap;
import java.util.Map;

/*
https://www.careercup.com/question?id=5684278553739264
 */
public class LongestSubstrUnrepeatedChar {
    public static String solution(String s) {
        String longestSoFar = "";
        String longest = "";
        Map<Character, Integer> map = new HashMap<>();

        if (s.isEmpty())
            return "";

        if (s.length() == 1)
            return s;

        for (var i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (longestSoFar.indexOf(tmp) == -1) {
                if (!map.containsKey(tmp)) {
                    map.put(tmp, i);
                }

                longestSoFar = longestSoFar + tmp;
            } else {
                longestSoFar = s.substring(map.get(tmp) + 1, i + 1);
                map.put(tmp, i);
            }

            if (longestSoFar.length() > longest.length()) {
                longest = longestSoFar;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        System.out.println(solution(str));

        str = "ABDEFGABEF";
        System.out.println(solution(str));
    }
}

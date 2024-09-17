package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class LC49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // base case
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] count = new char[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String s = String.valueOf(count);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

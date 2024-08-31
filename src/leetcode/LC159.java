package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * “Longest Substring with At Most Two Distinct Characters” asks you to find the length of the longest substring in a
 * given string that contains at most two distinct characters.
 *
 * Example 1:
 *
 * 	•	Input: s = "eceba"
 * 	•	Output: 3
 * 	•	Explanation: The substring "ece" contains only two distinct characters and is the longest possible such substring.
 *
 * Example 2:
 *
 * 	•	Input: s = "ccaabbb"
 * 	•	Output: 5
 * 	•	Explanation: The substring "aabbb" contains only two distinct characters and is the longest possible such substring.
 *
 * Approach:
 *
 * A common and efficient approach to solving this problem is to use the sliding window technique combined with a hash map (or dictionary) to track the frequency of characters within the current window.
 *
 * Sliding Window Technique:
 *
 * 	•	Expand the window by moving the right pointer (right) and including characters in the window.
 * 	•	Contract the window by moving the left pointer (left) when there are more than two distinct characters in the window. Remove characters from the left until only two distinct characters remain.
 * 	•	Keep track of the maximum length of a valid substring during the process.
 */
public class LC159 {

    public static void main(String[] args) {
        LC159 lc159 = new LC159();
        String s = "ccaabbb";
        System.out.println(lc159.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            // can be generalized to size k also
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                map.remove(leftChar, 0);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

package Strings;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/discuss/1805020/Java-HashMap-Sliding-Window
 */
public class Leetcode424 {

    public static int solution(String s, int k) {
        char[] array = new char[26];
        int i = 0;
        int result = 0;
        int windowSize = 0;
        int maxFrequency = 0;
        // window size - (freq of most repeated element) should be less than k
        for (var j = 0; j < s.length(); j++) {
            int ch = s.charAt(j) - 'A';
            array[ch]++;
            windowSize = j - i + 1;
            maxFrequency = Math.max(maxFrequency, array[ch]);
            if (windowSize - maxFrequency <= k) {
                result = Math.max(result, windowSize);
            } else {
                array[ch]--;
                i++;
            }
        }

        return result;
    }
}

package Strings;

/*
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 */
public class StringWithAllSubCharacters {
    // solution for string containing the chars exactly once
    public static int solution(String s) {
        int[] count = {0, 0, 0};

        int j = 0, result = 0;

        for (var i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;

            while (j < s.length() && count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result++;
                count[s.charAt(j) - 'a']--;
                j++;
            }
        }

        return result;
    }


    // https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/1735902/Java-Sliding-window-O(N)-solution
    public static int solution2(String s) {
        int j =0, result = 0;
        int length = s.length();
        int[] count = new int[3];

        for (var i = 0; i < length; i++) {
            count[s.charAt(i) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += length - i;
                count[s.charAt(j++) - 'a']--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String string = "abcabc";
        System.out.println(solution(string));
        System.out.println(solution2(string));
    }
}

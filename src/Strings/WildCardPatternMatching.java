package Strings;

/*
https://www.geeksforgeeks.org/dynamic-programming-wildcard-pattern-matching-linear-time-constant-space/?ref=lbp
 */
public class WildCardPatternMatching {

    public static boolean isMatch(String text, String pattern) {
        if (pattern.length() == 0)
            return text.length() == 0;

        int m = text.length();
        int n = pattern.length();

        int i = 0, j = 0, textIndex = -1, patternIndex = -1;

        while (i < m) {
            if (j < n && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && pattern.charAt(j) == '*') {
                textIndex = i;
                patternIndex = j;
                j++;
            } else if (patternIndex != -1) {
                j = patternIndex + 1;
                i = textIndex + 1;
                textIndex++;
            } else {
                return false;
            }
        }

        while (j < n && pattern.charAt(j) == '*')
            j++;

        return j == n;
    }

    public static void main(String[] args) {
        String text = "baaabxyab";
        String pattern = "*****ba*****ab";

        System.out.println(isMatch(text, pattern));

        pattern = "a*ab";
        System.out.println(isMatch(text, pattern));
    }
}

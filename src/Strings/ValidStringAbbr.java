package Strings;

/*
https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/408-valid-word-abbreviation.html
 */
public class ValidStringAbbr {
    public static boolean solution(String word, String abbr) {
        if (word == null && abbr != null) {
            return false;
        }

        int count = 0;
        int i = 0,j = 0;
        for (i = 0; i < abbr.length(); i++) {
            char ch = abbr.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (count == 0 && ch == '0') {
                    return false;
                }
                count = count * 10 + ch - '0';
            } else {
                if (count != 0) {
                    j += count;
                    count = 0;
                }

                if (j >= word.length() || ch != word.charAt(j)) {
                    return false;
                }
                j++;
            }
        }

        return i == abbr.length() && j == word.length();
    }
}

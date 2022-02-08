package Strings;

/*
https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/?ref=lbp
 */
public class MinimumWindowSubstring {
    public static void solution(String string, String pattern) {
        int len1 = string.length();
        int len2 = pattern.length();

        int[] sCount = new int[256];
        int[] pCount = new int[256];

        if (len1 < len2) {
            System.out.println("No solution");
            return;
        }

        for (var i = 0; i < len2; i++) {
            pCount[pattern.charAt(i)]++;
        }

        int start = 0, length = Integer.MAX_VALUE, startIndex = -1, count = 0;
        for (var i = 0; i < len1; i++) {
            sCount[string.charAt(i)]++;

            if (sCount[string.charAt(i)] <= pCount[string.charAt(i)]) {
                count++;
            }

            if (count == len2) {
                while (sCount[string.charAt(start)] > pCount[string.charAt(start)] || pCount[string.charAt(start)] == 0) {
                    if (sCount[string.charAt(start)] > pCount[string.charAt(start)]) {
                        sCount[string.charAt(start)]--;
                    }

                    start++;
                }

                if (length > (i - start + 1)) {
                    length = (i - start + 1);
                    startIndex = start;
                }
            }
        }

        if (startIndex == -1) {
            System.out.println("No solution");
        } else {
            System.out.println(string.substring(startIndex, startIndex + length));
        }
    }

    public static void main(String[] args) {
        String s = "adobecodebanc";
        String p = "ibac";
        solution(s, p);
    }
}

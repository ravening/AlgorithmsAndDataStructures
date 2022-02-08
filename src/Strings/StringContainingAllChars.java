package Strings;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
 */
public class StringContainingAllChars {
    public static void solution(String s) {
        int[] count = new int[256];
        int distinct = 0;
        for (var i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 0) {
                count[s.charAt(i)]++;
                distinct++;
            }
        }

        Arrays.fill(count, 0);

        int answer = Integer.MAX_VALUE;
        int start = 0, end, startIndex = 0;
        int c = 0;
        for (var i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;

            if (count[s.charAt(i)] == 1) {
                c++;
            }

            if (c == distinct) {
                while (count[s.charAt(start)] > 1) {
                    if (count[s.charAt(start)] > 1) {
                        count[s.charAt(start)]--;
                    }
                    start++;
                }

                if (answer > (i - start + 1)) {
                    answer = Math.min(answer, (i - start + 1));
                    startIndex = start;
                }
            }
        }

        System.out.println(s.substring(startIndex));
    }

    public static void main(String[] args) {
        String string = "aabcbcdbca";
        solution(string);
    }
}

package Strings;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/length-smallest-sub-string-consisting-maximum-distinct-characters/
 */
public class SubstringMaxDistinctChars {
    public static void solution(String s) {
        int start = 0, distinct = 0, startIndex = 0;
        int current = 0;
        int[] count = new int[256];

        for (var i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 0) {
                count[s.charAt(i)]++;
                distinct++;
            }
        }
        int length = Integer.MAX_VALUE;

        Arrays.fill(count, 0);

        for (var i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;

            if (count[s.charAt(i)] == 1) {
                current++;
            }

            if (current == distinct) {
                while (count[s.charAt(start)] > 1) {
                    if (count[s.charAt(start)] > 1) {
                        count[s.charAt(start)]--;
                    }
                    start++;
                }

                if (length > (i - start + 1)) {
                    length = (i - start + 1);
                    startIndex = start;
                }
            }
        }

        System.out.println(s.substring(startIndex));
    }

    public static void main(String[] args) {
        String string = "geeksgeeksfor";
        solution(string);
    }
}

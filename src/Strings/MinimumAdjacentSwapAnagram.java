package Strings;

import java.util.Arrays;

public class MinimumAdjacentSwapAnagram {
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] array1 = new int[256];
        int[] array2 = new int[256];

        for (var i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i)]++;
            array2[s2.charAt(i)]++;
        }

        return Arrays.equals(array1, array2);
    }

    public void solution(String s1, String s2) {
        if (!isAnagram(s1, s2)) {
            System.out.println(0);
            return;
        }

        int i = 0, j = 0;
        int result = 0;

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        while (i < array1.length) {
            j = i;

            while (array1[j] != array2[i]) {
                j++;
            }

            while (j > i) {
                char tmp = array1[j];
                array1[j] = array1[j-1];
                array1[j-1] = tmp;
                j--;
                result++;

            }
            i++;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        MinimumAdjacentSwapAnagram solution = new MinimumAdjacentSwapAnagram();
        solution.solution("abcd", "cdab");
    }
}

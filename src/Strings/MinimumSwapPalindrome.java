package Strings;

/*
https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
 */
public class MinimumSwapPalindrome {
    public int solution(String s) {
        int length = s.length();

        char[] array = s.toCharArray();
        int left = 0, right = length - 1;
        int count = 0;

        for (left = 0; left < length / 2; left++) {
            right = length - left - 1;
            while (left < right) {
                if (array[left] == array[right]) {
                    break;
                } else {
                    right--;
                }
            }

            if (left == right) {
                return -1;
            } else {
                for (var j = right; j < length - left - 1; j++) {
                    char ch = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = ch;
                    count++;

                }
            }
        }

        return count;
    }
}

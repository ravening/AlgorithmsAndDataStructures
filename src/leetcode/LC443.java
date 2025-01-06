package leetcode;

public class LC443 {

    public int compress(char[] chars) {
        int result = 0;
        int i = 0;
        int length = chars.length;
        int count = 0;

        while (i < length) {
            char currentChar = chars[i];

            while (i < length && currentChar == chars[i]) {
                i++;
                count++;
            }

            chars[result++] = currentChar;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[result++] = c;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC443 lc443 = new LC443();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(lc443.compress(chars));  // Output: 6

        chars = new char[]{'a'};
        System.out.println(lc443.compress(chars));  // Output: 1

        chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(lc443.compress(chars));  // Output: 4
    }
}

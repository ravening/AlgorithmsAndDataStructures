package src.Strings;

/*
https://www.geeksforgeeks.org/minimum-removals-required-such-that-given-string-consists-only-of-a-pair-of-alternating-characters/?ref=rp
 */
public class AlternatingCharacters {
    public int solution(String s) {
        int n = s.length();
        int len = 0, newLen = 0;

        for (var i = 0; i < 26; i++) {
            for (var j = i; j < 26; j++) {
                newLen = findLength(s, (char) (i + 97), (char) (j + 97));
                len = Math.max(len, newLen);
            }
        }

        return n - len;
    }

    private int findLength(String s, char x, char y) {
        int length = 0;

        char required = x;

        for (var k = 0; k < s.length(); k++) {
            if (s.charAt(k) == required) {
                length++;

                required = required == x ? y : x;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        AlternatingCharacters problem = new AlternatingCharacters();
        String s = "adebbeeaebd";
        System.out.println(problem.solution(s));
    }
}

package Strings;

/*
https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
 */
public class InterleavedCharacters {

    public static boolean solution(String a, String b, String c) {
        if (c.length() != (a.length() + b.length()))
            return false;

        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

        for (var i = 0; i <= a.length(); i++) {
            for (var j = 0; j <= b.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (b.charAt(j-1) == c.charAt(j - 1))
                        dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    if (a.charAt(i - 1) == c.charAt(i - 1))
                        dp[i][j] = dp[i-1][j];
                } else if ((a.charAt(i-1) == c.charAt(i + j -1) && (b.charAt(j-1) != c.charAt(i + j -1)))) {
                    dp[i][j] = dp[i-1][j];
                } else if ((a.charAt(i-1) != c.charAt(i + j -1)) && (b.charAt(j-1) == c.charAt(i + j -1))) {
                    dp[i][j] = dp[i][j-1];
                } else if ((a.charAt(i-1) == c.charAt(i+j-1)) && (b.charAt(j-1) == c.charAt(i + j -1))) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[a.length()][b.length()];
    }

    static void test(String A, String B, String C)
    {
        if (solution(A, B, C))
            System.out.println(C + " is interleaved of " +
                    A + " and " + B);
        else
            System.out.println(C + " is not interleaved of " +
                    A + " and " + B);
    }

    public static void main(String[] args) {
        test("XXY", "XXZ", "XXZXXXY");
        test("XY", "WZ", "WZXY");
        test("XY", "X", "XXY");
        test("YX", "X", "XXY");
        test("XXY", "XXZ", "XXXXZY");
    }
}

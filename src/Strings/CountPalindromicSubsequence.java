// https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/

// idea is to calculate the length of palindrom subseqeunce of
// adjacent character, alternate characters, characters at distance of 3,
// characters at distance of 4 and so on
// so palindrom subsequence of 0,i is nothing but 0,i-1 and 1, i
// 0,i-1 is 0,i-2 and 1, i-1 and so on
// the smaller onces are calculated before finding the palindromic
// subsequence of bigger length string
package Strings;

public class CountPalindromicSubsequence {
    public int solution(String string) {
        if (string == null || string.length() == 0)
            return 0;

        int N = string.length();
        int lcs[][] = new int[N+1][N+1];

        int i, j, k;

        for (i = 0; i< N; i++) {
            lcs[i][i] = 1;
        }

        for (j = 2; j <= N; j++) {
            for (i = 0 ; i < N; i++) {
                k = j + i - 1;
                if (k < N) {
                    // first compare adjacent and then keep increasing the distance
                    // between them
                    if (string.charAt(i) == string.charAt(k)) {
                        lcs[i][k] = lcs[i + 1][k] + lcs[i][k - 1] + 1;
                    } else {
                        lcs[i][k] = lcs[i + 1][k] + lcs[i][k - 1] - lcs[i + 1][k - 1];
                    }
                }
            }
        }
        return lcs[0][N-1];
    }
}

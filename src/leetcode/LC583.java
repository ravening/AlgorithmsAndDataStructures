package leetcode;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 */
public class LC583 {

    // calculate longest common subsequence. then the final result will be
    // (word1 length - lcs) + (word2 length - lcs)
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() && word2.isEmpty()) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (var i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return (m - dp[m][n]) + (n - dp[m][n]);
    }
}

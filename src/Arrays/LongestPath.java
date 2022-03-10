package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 */
public class LongestPath {
    public void solution(int[][] matrix) {
        int result = 1;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (var i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] == -1) {
                    findLongestPath(matrix, dp, i, j);
                }

                result = Math.max(result, dp[i][j]);
            }
        }
    }

    private int findLongestPath(int[][] matrix, int[][] dp, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix.length)
            return -1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
        int n = matrix.length;

        if (i < n -1 && matrix[i+1][j] > matrix[i][j]) {
            a = dp[i][j] = 1 + findLongestPath(matrix, dp, i+1, j);
        }

        if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
            b = dp[i][j] = 1 + findLongestPath(matrix, dp, i-1, j);
        }
        if (j < n -1 && matrix[i][j+1] > matrix[i][j]) {
            c = dp[i][j] = 1 + findLongestPath(matrix, dp, i, j+1);
        }

        if (j > 0 && matrix[i][j-1] > matrix[i][j]) {
            d = dp[i][j] = 1 + findLongestPath(matrix, dp, i, j-1);
        }

        return dp[i][j] = Math.max(a, Math.max(b, Math.max(c, Math.max(d, 1))));
    }
}

package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/minimum-cells-required-reach-destination-jumps-equal-cell-values/?ref=rp
 */
public class MinimumCellsDestination {
    public static int solution(int[][] array) {
        int m = array.length;
        int n = array[0].length;

        int[][] dp = new int[m][n];

        for (var arr: dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dp[0][0] = 1;

        for (var i = 0; i <m; i++) {
            for (var j = 0; j < n; j++) {
                if (dp[i][j] != Integer.MAX_VALUE && array[i][j] + j < n && (dp[i][j] + 1 < dp[i][j + array[i][j]])) {
                    dp[i][j + array[i][j]] = dp[i][j] + 1;
                }

                if (dp[i][j] != Integer.MAX_VALUE && array[i][j] + i < m && (dp[i][j] + 1 < dp[i + array[i][j]][j])) {
                    dp[i + array[i][j]][j] = dp[i][j] + 1;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int mat[][] = { { 2, 3, 2, 1, 4 },
                { 3, 2, 5, 8, 2 },
                { 1, 1, 2, 2, 1 }};

        System.out.println(solution(mat));
    }
}

package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/gold-mine-problem/
 */
public class GoldMine {
    public static int solution(int[][] array) {
        int[][] dp = new int[array.length][array[0].length];

        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        int m = array.length;;
        int n = array[0].length;

        for (var i = 0; i < m; i++) {
            dp[i][0] = array[i][0];
        }
        for (var j = 0; j < array.length; j++) {
            for (var i = 0; i < array[0].length; i++) {
                int topLeft = isValid(i-1, j-1, m , n) ? dp[i-1][j-1] : 0;
                int left = isValid(i, j-1, m , n) ? dp[i][j-1] : 0;
                int bottomLeft = isValid(i+1, j-1, m, n) ? dp[i+1][j-1] : 0;

                dp[i][j] = array[i][j] + Math.max(topLeft, Math.max(left, bottomLeft));
            }
        }

        int res = 0;

        for (var i = 0; i < m; i++) {
            res = Math.max(res, dp[i][n-1]);
        }

        return res;
    }

    public static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int gold[][]= {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        System.out.println(solution(gold));
    }
}

package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/gold-mine-problem/?ref=lbp
 */
public class GoldMining {
    public static void main(String[] args) {
        int gold[][]= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };

        System.out.println(solution(gold));
    }

    public static int solution(int[][] goldMine) {
        int[][] dp = new int[goldMine.length][goldMine[0].length];

        for (var arr : dp) {
            Arrays.fill(arr, 0);
        }

        for (var col = goldMine[0].length - 1; col >= 0; col--) {
            for (var row = 0; row < goldMine.length; row++) {
                int right = (col == goldMine[0].length - 1) ? 0 : dp[row][col + 1];
                int rightUp = ((col == goldMine[0].length -1) || (row == 0)) ? 0 : dp[row-1][col + 1];
                int rightDown = ((col == goldMine[0].length - 1) || (row == goldMine.length - 1)) ? 0 : dp[row + 1][col + 1];

                dp[row][col] = goldMine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int max = dp[0][0];

        for (var i = 1; i < goldMine.length; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}

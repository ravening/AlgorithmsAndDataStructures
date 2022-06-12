package Arrays;

/*
https://leetcode.ca/2021-03-29-1746-Maximum-Subarray-Sum-After-One-Operation/#:~:text=Return%20the%20maximum%20possible%20subarray,subarray%20must%20be%20non%2Dempty.&text=Explanation%3A%20You%20can%20perform%20the,%2D1%20%2B%2016%20%3D%2017.
 */
public class MaxSumAfter1Operation {

    public int solution(int[] array) {
        int[][] dp = new int[array.length][3];
        dp[0][0] = array[0];
        dp[0][1] = array[0] * array[0];
        dp[0][2] = Integer.MIN_VALUE;

        int max = dp[0][1];

        for (var i = 1; i < array.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], 0) + array[i];
            dp[i][1] = Math.max(dp[i-1][0], 0) + (array[i] * array[i]);
            dp[i][2] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), 0) + array[i];

            int curMax = Math.max(dp[i][1], dp[i][2]);
            max = Math.max(curMax, max);
        }

        return max;
    }
}

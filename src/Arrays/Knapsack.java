package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/space-optimized-dp-solution-0-1-knapsack-problem/
 */
public class Knapsack {

    public static int knapsack(int[] values, int[] weights, int weight) {
        int[] dp = new int[weight+1];
        Arrays.fill(dp, 0);

        for (var i = 0; i < weights.length; i++) {
            for (var w = weight; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
            }
        }

        return dp[weight];
    }

    public static void main(String[] args) {
        int val[] = {7, 8, 4}, wt[] = {3, 8, 6}, W = 10, n = 3;
        System.out.println(knapsack(val, wt, W));
    }
}

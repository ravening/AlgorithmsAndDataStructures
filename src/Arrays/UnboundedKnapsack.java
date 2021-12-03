package Arrays;

import java.util.Arrays;

/*
https://iq.opengenus.org/unbounded-knapsack-problem/
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int val[] = {10,30,20};
        int weight[] = {5, 10, 15};

        int Capacity = 100;

        System.out.println(solution(Capacity, weight, val));
    }

    public static double solution(int capacity, int[] weight, int[] value) {
        int[] dp = new int[capacity  +1];
        Arrays.fill(dp, 0);

        if (weight.length == 0 || capacity == 0)
            return 0;

        for (var i = 0; i <= capacity; i++) {
            for (var j = 0; j < weight.length; j++) {
                if (weight[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }

        return dp[capacity];
    }
}

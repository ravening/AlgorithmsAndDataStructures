package leetcode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/solutions/144682/3-lines-java-solution-o-1-space/
 */
public class LC746 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i];
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        if (cost.length <= 2) {
            return Math.min(cost[0], cost[1]);
        }
        int oneStepBefore = cost[1];
        int twoStepsBefore = cost[0];

        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(oneStepBefore, twoStepsBefore) + cost[i];
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return Math.min(oneStepBefore, twoStepsBefore);
    }
}

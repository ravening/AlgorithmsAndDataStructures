package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LeetCode983 {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet();
        for (var day : days) {
            set.add(day);
        }
        
        int[] dp = new int[30];
        dp[0] = 0;
        int lastDay = days[days.length - 1];
        for (var day =1; day <= lastDay; day++) {
            if (!set.contains(day)) {
                dp[day % 30] = dp[(day - 1) % 30];
            } else {
                dp[day % 30] = Math.min(dp[(day - 1) % 30] + costs[0],
                                       Math.min(dp[Math.max(0, day - 7) % 30] + costs[1],
                                               dp[Math.max(0, day - 30) % 30] + costs[2]));
            }
        }
        
        for (var i = 0; i < 30; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[days[days.length - 1] % 30];
        
    }

    public static void main(String[] args) {
        LeetCode983 solution = new LeetCode983();
        int[] days = new int[] {1,4,6,7,8,20};
        int[] costs = new int[] {2, 7, 15};
        System.out.println(solution.mincostTickets(days, costs));
    }
}

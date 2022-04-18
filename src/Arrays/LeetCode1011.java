package Arrays;

import java.util.Arrays;

public class LeetCode1011 {
    public int shipWithinDays(int[] weights, int days) {
        int minimum = 0;
        int sum = 0;
        
        minimum = Arrays.stream(weights).max().getAsInt();
        sum = Arrays.stream(weights).sum();
        
        while (minimum < sum) {
            int mid = (sum + minimum) / 2;
            if (feasible(weights, days, mid)) {
                sum = mid;
            } else {
                minimum = mid + 1;
            }
        }
        
        return minimum;
    }
    
    public boolean feasible(int[] weights, int days, int mid) {
        
        int sum = 0;
        int day = 1;
        for (var weight : weights) {
            sum += weight;
            if (sum > mid) {
                sum = weight;
                day++;
            }
        }
        
        return day <= days;
    }

    public static void main(String[] args) {
        LeetCode1011 solution = new LeetCode1011();
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(solution.shipWithinDays(weights, days));
    }
}

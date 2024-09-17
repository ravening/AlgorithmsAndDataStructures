package leetcode;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/solutions/90627/java-solution-similar-to-backpack-problem-easy-to-understand/
 */
public class LC416 {

    public boolean canPartition(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (var i = 0; i < nums.length; i++) {
            for (var j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[sum];
    }
}

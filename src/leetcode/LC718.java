package leetcode;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 */
public class LC718 {

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }

        int m = nums1.length;
        int n = nums2.length;

        // create a 2d array
        int[][] dp = new int[m+1][n+1];

        int maxLen = 0;
        for (var i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                // if characters are same
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}

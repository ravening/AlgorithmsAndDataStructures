package src.Strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LCS {
    static int[][] dp;
    public static int lcs(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return 0;
        dp = new int[str1.length() + 1][str2.length() + 1];
        int m = str1.length();
        int n = str2.length();
        for (var i = 0 ; i <= m; i++) {
            for (var j = 0; j <= n ; j++) {
                if ( i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

//        System.out.println("LCS length is " + dp[m][n]);
        return dp[m][n];
    }

    public static Set<String> displayAllLcs(String str1, String str2, int x, int y) {
        Set<String> set = new HashSet<>();
        if (x == 0 || y == 0) {
            set.add("");
            return set;
        }

        if (str1.charAt(x-1) == str2.charAt(y-1)) {
            Set<String> tmp = displayAllLcs(str1, str2, x-1, y-1);
            for (String s : tmp) {
                s = s + str1.charAt(x - 1);
                set.add(s);
            }
        } else {
            if (dp[x-1][y] >= dp[x][y-1]) {
                set = displayAllLcs(str1, str2, x-1, y);
            }
            if (dp[x][y-1] >= dp[x-1][y]) {
                Set<String> tmp = displayAllLcs(str1, str2, x, y-1);
                set.addAll(tmp);
            }
        }

        return set;
    }
}

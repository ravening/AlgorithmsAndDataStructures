package Strings;

/*
https://iq.opengenus.org/longest-repeating-non-overlapping-substring/

explanation
https://www.youtube.com/watch?v=KRQSOygJvuU
 */
public class LongestRepeatedNonoverlappingSubstring {
    public static void main(String[] args) {
        String s = "opengenus";
        LongestRepeatedNonoverlappingSubstring obj = new LongestRepeatedNonoverlappingSubstring();
        System.out.println(obj.solution(s));
        s = "aabaabaaba";
        System.out.println(obj.solution(s));
    }

    public String solution(String s) {
        if (s.length() <2) {
            return "";
        }

        int max = 0, index = 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (var i = 1; i <= s.length(); i++) {
            for (var j = i+1; j <= s.length(); j++) {
                if (s.charAt(i-1) == s.charAt(j-1) && dp[i-1][j-1] < (j - i)) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                    index = Math.max(index, i);
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max > 0 ? s.substring(index - max, index) : "";
    }
}

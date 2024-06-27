package Arrays;

/*
https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
 */
public class MobileKeypad {
    public static int solution(int[][] keypad, int length) {
        if (keypad == null || length <= 0)
            return 0;

        if (length == 1)
            return 10;

        int[][] dp = new int[10][length+1];

        for (var i = 0; i < 2; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        int[] rows = new int[]{0, 0, -1, 0, 1};
        int[] cols = new int[] {0, -1, 0, 1, 0};

        for (var k = 2; k <=length; k++) {
            for (var i = 0; i < 4; i++) {
                for (var j = 0; j < 3; j++) {
                    if (keypad[i][j] != '#' || keypad[i][j] != '*') {
                        var num = keypad[i][j] - '0';
                        dp[num][k] = 0;
                        for (var x = 0; x < rows.length; x++) {
                            var row = i + rows[x];
                            var col = j + cols[x];
                            if (keypad[row][col] != '#' || keypad[row][col] != '*') {
                                var next = keypad[row][col] - '0';
                                dp[num][k] += dp[next][k-1];
                            }
                        }
                    }
                }
            }
        }

        int total = 0;

        for (var i = 0; i < 10; i++) {
            total += dp[i][length];
        }
        return total;
    }
}

package Arrays;

/*
https://www.geeksforgeeks.org/collect-maximum-coins-before-hitting-a-dead-end/?ref=lbp
 */
public class Maxcoins {

    public int solution(int[][] matrix) {
        int[][][] dp = new int[matrix.length][matrix[0].length][2];
        return solution(matrix, 0, 0, 1, dp);
    }

    private int solution(int[][] matrix, int i, int j, int dir, int[][][] dp) {
        if (matrix[i][j] == '#' || !isValid(matrix, i, j))
            return 0;

        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        dp[i][j][dir] = (matrix[i][j] == 'C') ? 1 : 0;

        if (dir == 1) {
            dp[i][j][dir] += Math.max(solution(matrix, i + 1, j, 0, dp),
                    solution(matrix, i, j + 1, 1, dp));
        } else {
            dp[i][j][dir] += Math.max(solution(matrix, i + 1, j, 1, dp),
                    solution(matrix, i, j - 1, 0, dp));
        }

        return dp[i][j][dir];
    }

    private boolean isValid(int[][] matrix, int x, int y) {
        return (x >=0 && y>=0) && (x < matrix.length && y <= matrix[0].length);
    }
}

package Arrays;

public class CollectMaxPointsTwoTraversal {
    public int collectMaxPoints(int[][] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        int m = array.length;
        int n = array[0].length;

        int[][][] dp = new int[m][n][n];

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                for (var k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return collect(array, dp, m, n, 0, 0, n - 1);
    }

    private int collect(int[][] array, int [][][] dp, int m, int n, int row, int leftCol, int rightCol) {
        if (!isValid(m, n, row, leftCol, rightCol)) {
            return Integer.MIN_VALUE;
        }

        if (row == m -1 && (leftCol == 0 && rightCol == n - 1)) {
            return (leftCol == rightCol) ? array[row][leftCol] : array[row][leftCol] + array[row][rightCol];
        }

        if (row == m - 1) {
            return Integer.MIN_VALUE;
        }

        if (dp[row][leftCol][rightCol] != -1) {
            return dp[row][leftCol][rightCol];
        }

        int answer = Integer.MIN_VALUE;
        int temp = (leftCol == rightCol) ? array[row][leftCol] : array[row][leftCol] + array[row][rightCol];

        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol, rightCol - 1));
        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol, rightCol));
        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol, rightCol + 1));

        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol -1, rightCol - 1));
        answer = Math.max(answer, temp+ collect(array, dp, m, n, row + 1, leftCol -1, rightCol));
        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol - 1, rightCol + 1));

        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol + 1, rightCol - 1));
        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol + 1, rightCol));
        answer = Math.max(answer, temp + collect(array, dp, m, n, row + 1, leftCol + 1, rightCol + 1));

        return (dp[row][leftCol][rightCol] = answer);

    }

    private boolean isValid(int m, int n, int row, int leftCol, int rightCol) {
        return (row < m && leftCol >= 0 && rightCol >= 0 && leftCol < n && rightCol < n);
    }
}

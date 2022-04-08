package Arrays;

/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java-Solution
 */
public class LongestIncreasingPath {
    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int solution(int[][] graph) {
        int result = 0;

        int[][]dp = new int[graph.length][graph[0].length];

        for (var i = 0; i < graph.length; i++) {
            for (var j = 0; j < graph[0].length; j++) {
                int x = dfs(graph, dp, i, j);
                result = Math.max(result, x);
            }
        }

        return result;
    }

    private static int dfs(int[][] graph, int[][] dp, int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];
        int max = 1;

        for (var dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (!isValid(newX, newY, graph.length, graph[0].length) || graph[newX][newY] < graph[x][y])
                continue;

            int len = 1 + dfs(graph, dp, newX, newY);
            max = Math.max(max, len);
        }

        dp[x][y] = max;
        return max;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return (x > 0 && y> 0 && x < m && y < n);
    }
}

package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/unique-paths-covering-every-non-obstacle-block-exactly-once-in-a-grid/?ref=lbp
 */
public class UniquePath {
    int[][] array;
    boolean[][] visited;
    int answer;
    int nonObstacleCount;

    UniquePath(int[][] a) {
        array = a;
        visited = new boolean[a.length][a[0].length];
        for (var i = 0; i < array.length; i++)
            Arrays.fill(visited[i], false);
        answer = 0;
        nonObstacleCount =0;
    }

    private void solution() {
        int x = 0, y = 0;

        for (var i = 0; i < array.length;i++) {
            for (var j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    this.nonObstacleCount++;
                }

                if (array[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }

        dfs(x, y, 0);
    }

    private void dfs(int x, int y, int current) {
        visited[x][y] = true;
        if (array[x][y] == 0) {
            current++;
        }

        if (array[x][y] == 2) {
            if (current == this.nonObstacleCount)
                this.answer++;
            visited[x][y] = false;
            return;
        }

        if (x >= 1 && !visited[x-1][y] && array[x-1][y] != -1)
            dfs(x-1, y, current);

        if (x < array.length - 1 && !visited[x+1][y] && array[x+1][y] != -1)
            dfs(x+1, y, current);

        if (y >= 1 && !visited[x][y-1] && array[x][y-1] != -1)
            dfs(x, y-1, current);

        if (y < array[0].length - 1 && !visited[x][y+1] && array[x][y+1] != -1)
            dfs(x, y+1, current);

        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        UniquePath uniquePath =
                new UniquePath(grid);
        uniquePath.solution();
        System.out.println(uniquePath.answer);
    }
}

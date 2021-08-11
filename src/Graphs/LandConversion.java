package src.Graphs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
https://www.geeksforgeeks.org/minimum-number-of-water-to-land-conversion-to-make-two-islands-connected-in-a-grid/?ref=rp
 */
public class LandConversion {
    public int solution(char[][] array) {
        Set<Point> set1 = new HashSet<>();
        Set<Point> set2 = new HashSet<>();

        int answer = Integer.MAX_VALUE;

        for (var i = 0; i < array.length; i++) {
            for (var j = 0; j < array[0].length; j++) {
                if (array[i][j] == 'L') {
                    if (set1.isEmpty()) {
                        dfs(array, set1, i, j);
                    }

                    if (set2.isEmpty()) {
                        dfs(array, set2, i, j);
                    }
                }
            }
        }

        for (Point x : set1) {
            for (Point y : set2) {
                answer = Math.min(answer, distance(x, y));
            }
        }

        return answer;
    }

    private void dfs(char[][] array, Set<Point> set, int x, int y) {
        if (x < 0 || x >= array.length || y < 0 || y >= array[0].length || array[x][y] != 'L')
            return;

        set.add(new Point(x, y));
        array[x][y] = 'V';

        dfs(array, set, x - 1, y);
        dfs(array, set, x, y + 1);
        dfs(array, set, x + 1, y);
        dfs(array, set, x, y - 1);
    }
    private int distance(Point a, Point b) {
        return (Math.abs(a.x - b.x) + Math.abs(a.y - b.y) - 1);
    }

    public static void main(String[] args) {
        char[][] array = {
                {'W', 'L', 'W'},
                {'W', 'W', 'W'},
                {'W', 'W', 'L'}
        };

        LandConversion landConversion = new LandConversion();
        System.out.println(landConversion.solution(array));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

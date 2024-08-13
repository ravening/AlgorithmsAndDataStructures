package Arrays;

import java.util.LinkedList;
import java.util.Queue;

// leetcode 317

/**
 * Problem Description:
 *
 * You are given an m x n grid where each cell is one of three possible values:
 *
 * 	•	0 represents an empty land that you can pass by freely.
 * 	•	1 represents a building that you cannot pass through.
 * 	•	2 represents an obstacle that you cannot pass through.
 *
 * You want to find an empty land cell such that the sum of the distances from this cell to all the buildings is minimized. The distance is defined as the shortest path (number of steps) from one cell to another, moving only up, down, left, or right.
 *
 * Approach:
 *
 * 	1.	Breadth-First Search (BFS): Use BFS to calculate the shortest distance from each building to all reachable empty land cells.
 * 	2.	Tracking Distance and Reachable Buildings: Maintain two matrices:
 * 	•	distance[i][j]: Sum of distances from all buildings to the cell (i, j).
 * 	•	reach[i][j]: Number of buildings that can reach the cell (i, j).
 * 	3.	Iterate Through Each Building: Perform BFS from each building and update the distance and reach matrices.
 * 	4.	Find Minimum Distance: Iterate through all cells to find the minimum distance to all buildings.
 *
 *
 * 	Explanation of the Java Code:
 *
 * 	1.	distance and reach Matrices: These matrices track the total distance from all buildings and the number of buildings that can reach each cell, respectively.
 * 	2.	BFS from Each Building: For each building (grid[i][j] == 1), perform BFS to calculate distances to empty land cells. Update the distance and reach matrices during the BFS.
 * 	3.	Finding Minimum Distance: After processing all buildings, iterate through all cells to find the cell that is reachable by all buildings and has the minimum distance.
 *
 * This solution ensures that we calculate the shortest distance from all buildings to each empty land cell efficiently using BFS and track the necessary distances and reachability.
 */
public class ShortestDistFromAllBuilding {

    public static void main(String[] args) {
        ShortestDistFromAllBuilding sd = new ShortestDistFromAllBuilding();
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        System.out.println(sd.shortestDistance(grid));
    }
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return  -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];

        int minDistance = Integer.MAX_VALUE;
        int totalBuildings = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int[][] visited = new int[m][n];
                    int level = 1;
                    visited[i][j] = 1;
                    totalBuildings++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            int[] point = queue.poll();
                            int x = point[0], y = point[1];
                            for (int k = 0; k < 4; k++) {
                                int newX = x + dx[k];
                                int newY = y + dy[k];

                                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0 && visited[newX][newY] == 0) {
                                    visited[newX][newY] = 1;
                                    distance[newX][newY] += level;
                                    reach[newX][newY] = totalBuildings;
                                    queue.add(new int[]{newX, newY});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == totalBuildings && distance[i][j] < minDistance) {
                    minDistance = distance[i][j];
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}

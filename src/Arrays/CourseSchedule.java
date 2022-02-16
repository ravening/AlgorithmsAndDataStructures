package Arrays;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    /*
    DFS
     */
    public boolean courseSchedule(int numCourse, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (var i = 0; i < numCourse; i++) {
            adjList.add(new ArrayList<>());
        }

        for (var pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourse];

        for (var i = 0; i < numCourse; i++) {
            if (dfs(i, adjList, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> adjList, int[] visited) {
        visited[course] = 1;

        for (var i = 0; i < adjList.get(course).size(); i++) {
            int tmp = adjList.get(course).get(i);
            if (visited[tmp] == 1) {
                return true;
            }

            if (visited[tmp] == 0) {
                if (dfs(tmp, adjList, visited)) {
                    return true;
                }
            }
        }

        visited[course] = 2;
        return false;
    }

    public boolean solution(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1)
            return true;

        if (numCourses == 2 && prerequisites[0][0] == prerequisites[0][1])
            return false;

        int[] indegree = new int[numCourses];

        for (int[] array : prerequisites) {
            indegree[array[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (var i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] pre: prerequisites) {
                if (pre[1] == course) {
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }

        for (int i : indegree) {
            if (i != 0)
                return false;
        }

        return true;
    }


    /*
    https://leetcode.com/problems/course-schedule-ii/discuss/1761682/Java-Topological-Sort-with-explanation
     */
    public int[] solutionHashMap(int numberCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numberCourses];
        int[] courses = new int[numberCourses];
        for (var arr : prerequisites) {
            List<Integer> list = map.getOrDefault(arr[1], new ArrayList<>());
            list.add(arr[0]);
            indegree[arr[0]]++;
            map.put(arr[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int j : indegree) {
            if (j == 0) {
                queue.add(j);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            courses[index++] = course;
            if (map.containsKey(course)) {
                for (var others : map.get(course)) {
                    indegree[others]--;
                    if (indegree[others] == 0) {
                        queue.add(others);
                    }
                }
            }
        }

        return index == numberCourses ? courses : new int[0];
    }
}

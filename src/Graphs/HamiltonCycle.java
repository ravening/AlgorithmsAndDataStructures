package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HamiltonCycle {
    Stack<Integer> stack;
    boolean visited[];
    int count;
    List<Integer>[] adjList;
    int start;

    HamiltonCycle(int size) {
        adjList = new List[size + 1];
        for (var index = 0 ; index <= size; index++) {
            adjList[index] = new LinkedList<>();
        }
        visited = new boolean[size + 1];
        count = size + 1;
        stack = new Stack<>();
    }

    public boolean solution(int[] A, int[] B) {
        int length = A.length;

        HamiltonCycle hamiltonCycle = new HamiltonCycle(length);
        hamiltonCycle.buildGraph(A, B);
        hamiltonCycle.start = A[0];

        return findCycle();
    }

    public boolean findCycle() {
        stack.push(start);

        return solve(start);
    }

    public boolean  solve(int vertex) {
        if (vertex == start && stack.size() == count) {
            return true;
        }

        for (var neighbour : adjList[vertex]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                stack.push(neighbour);

                solve(neighbour);

                stack.pop();
                visited[neighbour] = false;
            }
        }

        return false;
    }
    public void buildGraph(int[] A, int[] B) {
        for (var index = 0; index < A.length; index++) {
            adjList[A[index]].add(B[index]);
        }
    }
}

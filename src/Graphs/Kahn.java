package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kahn {

    private int V;
    private final List<List<Integer>> adjList;
    private final int[] indegree;

    public Kahn(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        indegree = new int[V];
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        indegree[destination]++;
    }

    public List<Integer> topologicalSort() {
        if (V == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            return new ArrayList<>();
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int neighbor : adjList.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Kahn graph = new Kahn(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        List<Integer> integers = graph.topologicalSort();
        System.out.println(integers);

        int[] nums = new int[5];
        String[] strings = new String[5];


    }
}

/**
 * 5 - 2
 * 5 - 0
 * 4 - 0
 * 4 - 1
 * 2 - 3
 * 3 - 1
 */

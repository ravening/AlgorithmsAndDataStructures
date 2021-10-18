package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    int V;
    Set<Integer> suitableSet;
    List<List<Node>> adjList;
    int[] distance;
    PriorityQueue<Node> priorityQueue;

    Dijkstra(int v, List<List<Node>> adj) {
        this.V = v;
        suitableSet = new HashSet<>();
        distance = new int[V];
        adjList = adj;

        Comparator<Node> comparator = Node::getWeightDifference;
        priorityQueue = new PriorityQueue<>(comparator);
        Arrays.fill(distance, Integer.MAX_VALUE);
    }


    public void shortestDistance(int src) {
        distance[src] = 0;
        Node node = new Node(src, 0);

        priorityQueue.add(node);

        while (suitableSet.size() != V) {
            if (priorityQueue.isEmpty())
                return;

            Node tmp = priorityQueue.remove();

            if (suitableSet.contains(tmp.getVertex()))
                continue;

            suitableSet.add(tmp.getVertex());
            updateNeighbours(tmp);
        }
    }

    private void updateNeighbours(Node parent) {
        for (var i = 0; i < adjList.get(parent.getVertex()).size(); i++) {
            Node neighbour = adjList.get(parent.getVertex()).get(i);

            if (!suitableSet.contains(neighbour.getVertex())) {
                if (distance[parent.getVertex()] + neighbour.getWeight() < distance[neighbour.getVertex()]) {
                    distance[neighbour.getVertex()] = distance[parent.getVertex()] + neighbour.getWeight();
                    priorityQueue.add(new Node(neighbour.getVertex(), distance[neighbour.getVertex()]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        int source = 0;
        List<List<Node>> adj
            = new ArrayList<List<Node> >();

        for (int i = 0; i < v; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
  
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        Dijkstra dijkstra = new Dijkstra(v, adj);
        dijkstra.shortestDistance(source);

        for (var i = 0; i < dijkstra.distance.length; i++) {
            System.out.println(source + " to " + i + " is " + dijkstra.distance[i]);
        }
    }
}

/**
 * InnerDijkstra
 */
class Node {

    private int vertex;
    private int weight;

    Node(int v, int w) {
        this.vertex = v;
        this.weight = w;

    }

    public int getWeightDifference(Node other) {
        return weight - other.weight;
    }
    /**
     * @return int return the vertex
     */
    public int getVertex() {
        return vertex;
    }

    /**
     * @param vertex the vertex to set
     */
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    /**
     * @return int return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

}

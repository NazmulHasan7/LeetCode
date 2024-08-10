package Exercises.Graphs;
import java.util.ArrayList;

public class Graph_Implementation {
    // Graph Implementation using Adjacency List
    static class Edge {
        int source;
        int destination;
        int weight;
        Edge (int source, int destination) {
            this.source = source;
            this.destination = destination;
            this.weight = 0;
        }
        Edge (int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    // Array of Array List
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        // Print neighbors of 2
        for (Edge e : graph[2])
            System.out.print(e.destination + " ");
    }
}

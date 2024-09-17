package Exercises.Graphs;
import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algorithm {
    // edges: vector of vectors which represents the graph
    // S: source vertex to start traversing graph with
    // V: number of vertices
    // Shortest path to all nodes from source
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V]; // SC -> O(V)
        Arrays.fill(distance, (int) 1e8);
        distance[S] = 0;

        // Relax the distance array V-1 times
        for (int i=0; i<V; i++) { // TC -> O(V * E)
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);

                // make sure source is accessible and new distance is less
                if (distance[u] != 1e8 && distance[u] + w < distance[v])
                    distance[v] = distance[u] + w;
            }
        }
        // Relax one more time to detect negative cycle
        for (ArrayList<Integer> edge : edges) { // TC -> O(E)
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            if (distance[u] != 1e8 && distance[u] + w < distance[v])
                return new int[]{-1}; // there is a negative cycle
        }
        return distance; // TC -> O(V * E) + O(E)
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 9)));
        int V = 2;
        int S = 0;
        int[] result = bellman_ford(V, edges, S);
        System.out.println(Arrays.toString(result));
    }
}

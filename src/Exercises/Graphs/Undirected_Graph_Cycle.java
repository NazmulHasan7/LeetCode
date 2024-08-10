package Exercises.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Undirected_Graph_Cycle {
    // Graph Cycle Detection --> Undirected Graph
    // Condition -> 1) The node is already visited 2) The node is not the parent node
    private boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            // Do not visit the parent node
            if (neighbor == parent)
                continue;
            if (visited[neighbor])
                return true;
            if (isCycleDFS(adj, visited, neighbor, node))
                return true;
        } return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int u=0; u<V; u++)
            // if (!visited[u] && isCycleDFS(adj, visited, u, -1))
            if (!visited[u] && isCycleBFS(adj, visited, u))
                return true;
        return false;
    }
    private boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        Queue<int[]> queue = new LinkedList<>();
        // Pair of node and parent
        queue.add(new int[]{node, -1});
        visited[node] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int neighbor : adj.get(val[0])) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, val[0]});
                } else if (val[1] != neighbor) {
                    // if the node is visited already, and it is not the parent
                    // then there is a cycle
                    return true;
                }
            }
        } return false;
    }
}

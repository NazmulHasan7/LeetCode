package Exercises.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Directed_Graph_Cycle {
    // Directed Graph Cycle Detection - using BFS, DFS
    private boolean isCyclicDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] visitedInCurrentRecursion, int node) {
        visited[node] = visitedInCurrentRecursion[node] = true;
        // Check if a node is already visited in current recursion
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && isCyclicDFS(adj, visited, visitedInCurrentRecursion, neighbor))
                return true;
            else if (visitedInCurrentRecursion[neighbor])
                return true;
        }
        visitedInCurrentRecursion[node] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] visitedInCurrentRecursion = new boolean[V];

        for (int u=0; u<V; u++)
            if (!visited[u] && isCyclicDFS(adj, visited, visitedInCurrentRecursion, u))
                return true;
        return false;
    }
    // Using BFS Approach
    public boolean isCyclicBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];

        // Prepare in-degree count
        for (int u=0; u<V; u++)
            for (int v : adj.get(u))
                inDegree[v]++;

        // Push nodes with 0 in-degrees
        int count = 0;
        for (int i=0; i<V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        // BFS Traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        // If count matches the number of Vertices, then there is no cycle
        return count != V;
    }
}

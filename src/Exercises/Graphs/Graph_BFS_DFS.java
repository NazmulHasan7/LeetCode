package Exercises.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS_DFS {
    // BFS & DFS implementation for both Connected and Disconnected graph
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                queue.add(u);
                visited[u] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    answer.add(node);

                    for (int x : adj.get(node)) {
                        if (!visited[x]) {
                            queue.add(x);
                            visited[x] = true;
                        }
                    }
                }
            }
        } return answer;
    }
    private void dfs(ArrayList<Integer> answer, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        if (visited[node]) return;
        answer.add(node);
        visited[node] = true;

        for (int neighbor : adj.get(node))
            if (!visited[neighbor])
                dfs(answer, adj, visited, neighbor);
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int u=0; u<V; u++)
            if (!visited[u])
                dfs(answer, adj, visited, u);
        return answer;
    }
}

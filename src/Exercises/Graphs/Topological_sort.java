package Exercises.Graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class Topological_sort {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor])
                dfs(adj, stack, visited, neighbor);
        }
        stack.push(node);
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int u=0; u<V; u++)
            if (!visited[u])
                dfs(adj, stack, visited, u);

        int[] answer = new int[V];
        int idx = 0;
        while (!stack.isEmpty())
            answer[idx++] = stack.pop();
        return answer;
    }
    public static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];

        // Set up in-degree [incoming edges]
        for (int u=0; u<V; u++)
            for (int v : adj.get(u))
                inDegree[v]++;

        // Push the vertices with 0 in-degree to the queue
        for (int u=0; u<V; u++)
            if (inDegree[u] == 0) queue.add(u);

        // Breadth First Search
        int[] answer = new int[V];
        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            answer[idx++] = node;
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.add(neighbor);
            }
        } return answer;
    }
}

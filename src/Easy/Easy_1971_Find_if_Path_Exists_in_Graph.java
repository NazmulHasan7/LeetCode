// 1971. Find if Path Exists in Graph
package Easy;
import java.util.ArrayList;

public class Easy_1971_Find_if_Path_Exists_in_Graph {
    private static boolean dfs(ArrayList<Integer>[] adj, int source, int destination, boolean[] visited) {
        if (source == destination) return true;
        if (visited[source]) return false;

        visited[source] = true;
        for (int neighbor : adj[source])
            if (dfs(adj, neighbor, destination, visited))
                return true;
        return false;
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        // Convert edges to an adjacency list
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            // Bi-directional graph
            // source edge[0], destination edge[1]
            adj[edge[0]].add(edge[1]);
            // source edge[1], destination edge[0]
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj, source, destination, visited);
    }
    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println(validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }
}

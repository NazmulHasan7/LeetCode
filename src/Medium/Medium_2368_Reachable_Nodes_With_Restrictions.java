// 2368. Reachable Nodes With Restrictions
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2368_Reachable_Nodes_With_Restrictions {
    private static int count;
    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] visited = new boolean[n];
        // Mark the restricted nodes as already visited
        for (int x : restricted) visited[x] = true;

        // Make Graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for (int i=0; i<edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        count = 0;
        dfs(graph, 0, visited);
        return count;
    }
    private static void dfs(List<Integer>[] graph, int node, boolean[] visited) {
        if (visited[node]) return;

        count++;
        visited[node] = true;
        for (int neighbor : graph[node])
            if (!visited[neighbor])
                dfs(graph, neighbor, visited);
    }
    public static void main(String[] args) {
        System.out.println(reachableNodes(7, new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[]{4,5}));
        System.out.println(reachableNodes(7, new int[][]{{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}}, new int[]{4,2,1}));
    }
}

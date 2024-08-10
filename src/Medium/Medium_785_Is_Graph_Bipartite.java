// 785. Is Graph Bipartite
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_785_Is_Graph_Bipartite {
    private static boolean checkBipartiteDFS(int[][] graph, int[] color, int u, int currColor) {
        color[u] = currColor;
        for (int v : graph[u]) {
            // The color matches to its adjacent node
            if (color[v] == color[u])
                return false;
            if (color[v] == 0) {
                int nextColor = currColor == 1 ? 2 : 1;
                if (!checkBipartiteDFS(graph, color, v, nextColor))
                    return false;
            }
        } return true;
    }
    private static boolean checkBipartiteBFS(int[][] graph, int[] color, int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        color[u] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nextColor = color[node] == 1 ? 2 : 1;
            for (int neighbor : graph[node]) {
                if (color[neighbor] == color[node])
                    return false;
                if (color[neighbor] == 0) {
                    // The node is not colored yet
                    color[neighbor] = nextColor;
                    queue.add(neighbor);
                }
            }
        } return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i=0; i<n; i++)
            if (color[i] == 0) // The node is not colored yet
                if (!checkBipartiteDFS(graph, color, i, 1))
                    // if (!checkBipartiteBFS(graph, color, i))
                    return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
        System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }
}

// 547. Number of Provinces
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_547_Number_of_Provinces {
    static int n;
    private static void dfs(int[][] isConnected, boolean[] visited, int u) {
        visited[u] = true;
        for (int v=0; v<n; v++) {
            if (!visited[v] && isConnected[u][v] == 1)
                dfs(isConnected, visited, v);
        }
    }
    private static void bfs(int[][] isConnected, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v=0; v<n; v++) {
                if (!visited[v] && isConnected[u][v] == 1) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int u=0; u<n; u++) {
            if (!visited[u]) {
                provinces++;
                // dfs(isConnected, visited, u);
                bfs(isConnected, visited, u);
            }
        } return provinces;
    }
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
}

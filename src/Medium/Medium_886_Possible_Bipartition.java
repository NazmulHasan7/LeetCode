// 886. Possible Bi-partition
package Medium;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Medium_886_Possible_Bipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        // Create a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            // bidirectional graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n+1]; // 1 for group1, 2 for group2
        for (int i=1; i<=n; i++) {
            if (color[i] == 0) // not assigned into any group yet
                // if (!bfs(adj, color, i))
                if (!dfs(adj, color, i, 1))
                    return false;
        } return true;
    }
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int u, int currentColor) {
        color[u] = currentColor;
        for (int v : adj.get(u)) {
            if (color[u] == color[v]) return false;
            if (color[v] == 0) {
                int nextColor = currentColor == 1 ? 2 : 1;
                if (!dfs(adj, color, v, nextColor))
                    return false;
            }
        } return true;
    }
    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] color, int index) {
        color[index] = 1; // assign to group 1
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(index);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (color[v] == 0) {
                    // not assigned into any group yet
                    color[v] = color[u] == 1 ? 2 : 1;
                    queue.add(v);
                } else if (color[u] == color[v]) {
                    return false;
                }
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(possibleBipartition(5, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }
}

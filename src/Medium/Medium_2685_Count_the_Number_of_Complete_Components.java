// 2685. Count the Number of Complete Components
package Medium;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium_2685_Count_the_Number_of_Complete_Components {
    public static int countCompleteComponents(int n, int[][] edges) {
        // create graph from the edges
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int answer = 0;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int u=0; u<n; u++) {
            if (!visited[u]) {
                queue.add(u);
                visited[u] = true;
                int vCount = 0;
                int edgeCount = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    vCount++;
                    edgeCount += adj[node].size();

                    for (int neighbor : adj[node]) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;

                        }
                    }
                }
                // For n vertices, a complete component should have n*(n-1)/2 edges
                // Undirected graph -> same edge counted twice
                if (edgeCount/2 == (vCount * (vCount-1))/2)
                    answer++;
            }
        } return answer;
    }

    public static void main(String[] args) {
        System.out.println(countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4}}));
        System.out.println(countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}));
    }
}

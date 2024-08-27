// 802. Find Eventual Safe States
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_802_Find_Eventual_Safe_States {
    // Need to check for graph cycle, elements not associated to the cycle is safe node
    private static boolean dfs(int[][] graph, boolean[] visited, boolean[] visitedInCurrentCall, int node) {
        visited[node] = visitedInCurrentCall[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, visitedInCurrentCall, neighbor))
                    return true;
            } // If the neighbor node is visited already in the current recursion call then there is a cycle
            else if (visitedInCurrentCall[neighbor]) {
                return true;
            }
        }
        visitedInCurrentCall[node] = false;
        return false;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] visitedInCurrentCall = new boolean[V];

        for (int u=0; u<V; u++)
            if (!visited[u])
                dfs(graph, visited, visitedInCurrentCall, u);

        // Nodes associated to a cycle remains in the array
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<V; i++)
            if (!visitedInCurrentCall[i])
                answer.add(i);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
        System.out.println(eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));
    }
}

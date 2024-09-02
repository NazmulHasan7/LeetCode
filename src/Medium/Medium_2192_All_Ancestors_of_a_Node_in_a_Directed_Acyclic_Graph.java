// 2192. All Ancestors of a Node in a Directed Acyclic Graph
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2192_All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<n; i++)
            result.add(new ArrayList<>());

        // Generate graph
        ArrayList[] graph = new ArrayList[n];
        for (int i=0; i<n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges)
            graph[edge[0]].add(edge[1]);

        // DFS for each node, the node is the ancestor of the neighbors visited in the current dfs
        for (int i=0; i<n; i++) {
            boolean[] visitedInCurrentDFS = new boolean[n];
            dfs(i, i, graph, result, visitedInCurrentDFS);
        }
        return result;
    }
    private static void dfs(int parent, int current, ArrayList<Integer>[] graph, List<List<Integer>> result, boolean[] visited) {
        visited[current] = true;
        for (int neighbor : graph[current]) {
            if (!visited[neighbor]) {
                result.get(neighbor).add(parent);
                dfs(parent, neighbor, graph, result, visited);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(getAncestors(5, new int[][]{
                {0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}));
        System.out.println(getAncestors(8, new int[][]{
                {0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }
}

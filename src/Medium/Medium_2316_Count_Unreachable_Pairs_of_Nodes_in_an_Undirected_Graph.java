// 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
package Medium;
import java.util.*;

public class Medium_2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {
    // DFS Approach
    static int newVisited;
    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) return;
        newVisited++;
        visited[node] = true;

        for (int neighbor : adj.get(node))
            if (!visited[neighbor])
                dfs(neighbor, adj, visited);
    }
    public static long countPairs(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        // generate graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // traverse the graph and count the unvisited nodes
        int totalVisited = 0;
        long answer = 0;
        for (int u=0; u<n; u++) {
            if (!visited[u]) {
                newVisited = 0;
                dfs(u, adj, visited);
                totalVisited += newVisited;
                // to connect all the nodes to each other n * (n-1) edges required
                answer += ((long) newVisited * (n - totalVisited));
                // new visited nodes * unvisited nodes
            }
        } return answer;
    }


    // Union Find approach
    private static int find(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i], parent);
    }
    private static void union(int x, int y, int[] rank, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent) return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    public static long countPairsDSU(int n, int[][] edges) {
        int[] rank = new int[n];
        int[] parent = new int[n];
        // count the number of nodes for each component
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) parent[i] = i;

        for (int[] edge : edges)
            union(edge[0], edge[1], rank, parent);

        // count the nodes in each component
        for (int u=0; u<n; u++) {
            int uParent = find(u, parent);
            map.put(uParent, map.getOrDefault(uParent, 0) + 1);
        }
        long answer = 0;
        int unvisitedNodes = n;
        for (Map.Entry<Integer, Integer> component : map.entrySet()) {
            int newVisited = component.getValue();
            answer += ((long) newVisited * (unvisitedNodes - newVisited));
            unvisitedNodes -= newVisited;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(countPairs(3, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
        System.out.println(countPairsDSU(3, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(countPairsDSU(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
    }
}

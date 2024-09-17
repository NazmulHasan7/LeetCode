// 1443. Minimum Time to Collect All Apples in a Tree
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1443_Minimum_Time_to_Collect_All_Apples_in_a_Tree {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Create Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(adj, 0, -1, hasApple);
    }
    private static int dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, List<Boolean> hasApple) {
        int time = 0;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent)
                continue;
            int timeTakenByNeighbor = dfs(adj, neighbor, node, hasApple);
            if (timeTakenByNeighbor > 0 || hasApple.get(neighbor))
                time += timeTakenByNeighbor + 2;
        }
        return time;
    }
    public static void main(String[] args) {
        System.out.println(minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
                new ArrayList<>(Arrays.asList(false,false,true,false,true,true,false))));
        System.out.println(minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
                new ArrayList<>(Arrays.asList(false,false,true,false,false,true,false))));
    }
}

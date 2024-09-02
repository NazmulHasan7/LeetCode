// 684. Redundant Connection
package Medium;
import java.util.Arrays;

public class Medium_684_Redundant_Connection {
    private static int find(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i], parent);
    }
    private static void union(int x, int y, int[] rank, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // Range 1 to n -> [1,n]
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for (int i=0; i<n; i++) parent[i] = i;

        int[] answer = new int[2];
        for (int[] edge : edges) {
            if (find(edge[0], parent) == find(edge[1], parent)) {
                // A redundant connection is found
                answer = edge;
            } else {
                union(edge[0], edge[1], rank, parent);
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}})));
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}})));
    }
}

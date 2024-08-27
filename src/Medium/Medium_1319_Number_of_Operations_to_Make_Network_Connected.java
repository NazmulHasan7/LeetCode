// 1319. Number of Operations to Make Network Connected
package Medium;

public class Medium_1319_Number_of_Operations_to_Make_Network_Connected {
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
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
    public static int makeConnected(int n, int[][] connections) {
        // To connect n nodes, minimum n-1 edges are required
        if (connections.length < n-1)
            return -1;

        int[] rank = new int[n];
        int[] parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;

        // count the extra edges and make union
        int extraEdges = 0;
        for (int[] connection : connections) {
            if (find(connection[0], parent) == find(connection[1], parent)) {
                // both are already connected to the parent, current edge is extra
                extraEdges++;
            }  else {
                union(connection[0], connection[1], rank, parent);
            }
        }
        // Count how many different connects are there
        // Alternatively - count of the nodes that are the parent of itself
        int countConnections = 0;
        for (int i=0; i<n; i++) {
            if (i == parent[i])
                countConnections++;
        }
        return (extraEdges >= countConnections-1) ? countConnections - 1 : -1;
    }
    public static void main(String[] args) {
        System.out.println(makeConnected(4, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
        System.out.println(makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}}));
    }
}

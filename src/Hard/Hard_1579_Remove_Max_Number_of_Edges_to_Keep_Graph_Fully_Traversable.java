// 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
package Hard;
import java.util.Arrays;

public class Hard_1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        UnionFind(int n) {
            count = n;
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i=1; i<=n; i++) parent[i] = i;
        }
        int find(int i) {
            if (i == parent[i]) return i;
            return parent[i] = find(parent[i]);
        }
        void union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent != y_parent) {
                if (rank[x_parent] > rank[y_parent]) {
                    parent[y_parent] = x_parent;
                } else if (rank[y_parent] > rank[x_parent]) {
                    parent[x_parent] = y_parent;
                } else {
                    parent[y_parent] = x_parent;
                    rank[x_parent]++;
                } count--;
            }
        }
    }
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int addedEdge = 0;

        // sort the edges based on type edge[0], as the type 3 edge can be visited by both
        Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1], v = edge[2];
            boolean added = false;

            if (type == 3) {
                if (alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    added = true;
                }
                if (bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    added = true;
                }
            } else if (type == 2) {
                if (bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    added = true;
                }
            } else {
                if (alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    added = true;
                }
            }
            if (added) addedEdge++;
        }
        // if all the nodes are connected then count should be 1, as range [1,n]
        if (alice.count == 1 && bob.count == 1)
            return edges.length - addedEdge;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}}));
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3,2,3},{1,1,2},{2,3,4}}));
    }
}

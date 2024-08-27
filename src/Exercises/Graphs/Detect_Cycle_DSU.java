// Cycle detection using DSU
package Exercises.Graphs;
import java.util.ArrayList;

public class Detect_Cycle_DSU {
    // Union Find approach
    private int find(int i, int[] parent) {
        if (i == parent[i])
            // if the element itself is the parent
            return i;
        // path compression
        // now element's parent directly points to the parent of the set
        return parent[i] = find(parent[i], parent);
    }
    // Union -> Make parent based on rank
    /* How to decide the parent ?
            => When the ranks are equal -> Make anyone parent and increase the rank of the parent by 1
            => When the ranks are not same then node with higher rank becomes the parent */
    private void union(int u, int v, int[] parent, int[] rank) {
        int uParent = find(u, parent);
        int vParent = find(v, parent);

        // if both belong to the same parent then union is not needed
        if (uParent == vParent)
            return;
        if (rank[uParent] > rank[vParent]) {
            parent[vParent] = uParent;
        } else if (rank[vParent] > rank[uParent]) {
            parent[uParent] = vParent;
        } else {
            parent[uParent] = vParent;
            rank[vParent]++;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] rank = new int[V];
        int[] parent = new int[V];

        for (int i=0; i<V; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        // Cycle detection code
        for (int u=0; u<V; u++) {
            for (int v : adj.get(u)) {
                // to skip the already visited nodes
                if (u < v) {
                    int uParent = find(u, parent);
                    int vParent = find(v, parent);
                    if (uParent == vParent)
                        return true; // there is a cycle
                    union(u, v, parent, rank);
                }
            }
        } return false;
    }
}

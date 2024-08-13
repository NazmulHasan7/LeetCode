package Exercises.Graphs;

/*  Union Find ->
    Operation 1 -> Combine 2 given sets
    Operation 2 -> Tell if 2 members belong to the same set or not */
public class Disjoint_Set_Union {
    // Path Compression
    public static int find(int[] parent, int i) {
        if (i == parent[i]) // element == parent
            return i;
        return parent[i] = find(parent, parent[i]);
    }
    // Union -> Make parent based on rank
    /* How to decide the parent ?
            => When the ranks are equal -> Make anyone parent and increase the rank of the parent by 1
            => When the ranks are not same then node with higher rank becomes the parent */
    public void union(int x, int y, int[] parent, int[] rank) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);

        if (xParent == yParent)
            // Both belong to the same set
            return;
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[xParent]++;
        }
    }
}

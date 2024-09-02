// 2492. Minimum Score of a Path Between Two Cities
package Medium;

public class Medium_2492_Minimum_Score_of_a_Path_Between_Two_Cities {
    private static int find(int i, int[] parent) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }
    private static void union(int x, int y, int[] rank, int[] parent) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent != y_parent) {
            if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if (rank[y_parent] > rank[x_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }
    public static int minScore(int n, int[][] roads) {
        int[] rank = new int[n+1];
        int[] parent = new int[n+1];
        for (int i=0; i<=n; i++) parent[i] = i;

        for (int[] road : roads)
            // road[] => {source, destination}
            union(road[0], road[1], rank, parent);

        int srcParent = find(1, parent);
        int min = Integer.MAX_VALUE;
        for (int[] road : roads)
            // Since the graph is bidirectional
            // road[0] -> source, road[1] -> destination, road[2] -> score
            // road[0] -> destination, road[1] -> source, road[2] -> score
            if (srcParent == find(road[0], parent) || srcParent == find(road[1], parent))
                min = Math.min(min, road[2]);

        return min;
    }
    public static void main(String[] args) {
        System.out.println(minScore(4, new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}}));
        System.out.println(minScore(4, new int[][]{{1,2,2},{1,3,4},{3,4,7}}));
    }
}

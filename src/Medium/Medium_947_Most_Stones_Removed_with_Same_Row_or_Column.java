// 947. Most Stones Removed with Same Row or Column
package Medium;

public class Medium_947_Most_Stones_Removed_with_Same_Row_or_Column {
    // Intuition -> DFS on stones and count the number of groups
    // Stones that are visited in the same dfs call belong to the same group
    // Removed stones = Number of stone - number of groups
    private static void dfs(int[][] stones, boolean[] visited, int index) {
        // Mark the stone as visited
        visited[index] = true;
        for (int i=0; i<stones.length; i++) {
            if (!visited[i]) {
                int row = stones[index][0];
                int col = stones[index][1];
                if (stones[i][0] == row || stones[i][1] == col)
                    dfs(stones, visited, i);
            }
        }
    }
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int group = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                group++;
                dfs(stones, visited, i);
            }
        } return n - group;
    }
    // DSU Approach -> Union Find
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
    public static int removeStonesDSU(int[][] stones) {
        int n = stones.length;
        int[] rank = new int[n];
        int[] parent = new int[n];

        for (int i=0; i<n; i++) parent[i] = i;

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                // if both belong to the same row or column
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    union(i, j, rank, parent);

        int group = 0;
        for (int i=0; i<n; i++)
            if (parent[i] == i) group++;
        return n - group;
    }
    public static void main(String[] args) {
        System.out.println(removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
        System.out.println(removeStones(new int[][]{{0,0}}));
        System.out.println(removeStonesDSU(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(removeStonesDSU(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
        System.out.println(removeStonesDSU(new int[][]{{0,0}}));
    }
}

// 1615. Maximal Network Rank
package Medium;
import java.util.HashMap;
import java.util.HashSet;

public class Medium_1615_Maximal_Network_Rank {
    // TC -> O(n^2) SC -> O(n^2) => (node * hashset)
    public static int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i=0; i<n; i++) // O(n)
            map.put(i, new HashSet<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            map.get(u).add(v);
            map.get(v).add(u);
        } // O(E)

        int maxRank = 0;
        // Check for every pair
        for (int i=0; i<n; i++) { // O(n^2)
            for (int j=i+1; j<n; j++) {
                int rankI = map.get(i).size();
                int rankJ = map.get(j).size();
                int rank = rankI + rankJ;

                // If a road is directly connected to both cities, it is only counted once
                if (map.get(i).contains(j))
                    rank--;

                maxRank = Math.max(maxRank, rank);
            }
        } return maxRank;
    }

    public static int maximalNetworkRankOpt(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] hasRoad = new boolean[n][n];

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            degree[u]++;
            degree[v]++;
            hasRoad[u][v] = true;
            hasRoad[v][u] = true;
        }

        int maxRank = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int rankI = degree[i];
                int rankJ = degree[j];
                int rank = rankI + rankJ;
                if (hasRoad[i][j])
                    rank--;

                maxRank = Math.max(maxRank, rank);
            }
        } return maxRank;
    }

    public static void main(String[] args) {
        System.out.println(maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}}));
        System.out.println(maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
        System.out.println(maximalNetworkRank(8, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}}));
    }
}

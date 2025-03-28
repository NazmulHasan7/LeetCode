// 2924. Find Champion II
package Medium;

public class Medium_2924_Find_Champion_II {
    // TC -> O(m), SC -> O(n)
    public static int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges)
            inDegree[edge[1]]++;

        int minInDegree = Integer.MAX_VALUE;
        int count = 0, champion = -1;

        for (int i=0; i<n; i++) {
            int deg = inDegree[i];
            if (deg < minInDegree) {
                minInDegree = deg;
                count = 1;
                champion = i;
            } else if (deg == minInDegree) {
                count++;
                if (count > 1)
                    champion = -1;
            }
        } return champion;
    }
    public static void main(String[] args) {
        System.out.println(findChampion(3, new int[][]{{0,1},{1,2}}));
        System.out.println(findChampion(4, new int[][]{{0,2},{1,3},{1,2}}));
    }
}

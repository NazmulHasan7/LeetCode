// 1368. Minimum Cost to Make at Least One Valid Path in a Grid
package Hard;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Hard_1368_Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {
    // Recursion + Memoization -> TLE
    // Time Complexity: O(m×n×k) Space Complexity: O(m×n×k)
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int minCost(int[][] grid) {
        // Backtracking Approach
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashMap<String, Integer> memo = new HashMap<>();
        return dfs(grid, 0, 0, m, n, visited, 0, memo);
    }
    private static int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited, int cost, HashMap<String, Integer> memo) {
        if (i == m-1 && j == n-1) return cost;

        String key = i + "_" + j + "_" + cost;
        if (memo.containsKey(key))
            return memo.get(key);

        visited[i][j] = true;
        // Try in all 4 directions
        int minimumCost = Integer.MAX_VALUE;
        for (int dir_i=1; dir_i<=4; dir_i++) {
            int[] dir = directions[dir_i-1];
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                // If the directions do not match then add 1
                int updatedCost = cost + ((grid[i][j] != dir_i) ? 1 : 0);
                minimumCost = Math.min(minimumCost, dfs(grid, newI, newJ, m, n, visited, updatedCost, memo));
            }
        }
        memo.put(key, minimumCost);
        visited[i][j] = false;
        return minimumCost;
    }
    // TC -> O(mn log(mn)), SC -> O(mn)
    // Using Dijkstra's Shortest Path -> Greedy Algorithm
    public static int minCostOpt(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}}; // R L D U
        // Min heap sorted based on weight
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0,0,0}); // cost, row, column

        int m = grid.length, n = grid[0].length;
        int[][] minCosts = new int[m][n];

        for (int[] costs : minCosts)
            Arrays.fill(costs, Integer.MAX_VALUE);

        minCosts[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (minCosts[r][c] < cost)
                continue;

            for (int i=1; i<=4; i++) {
                int[] dir = directions[i-1];
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    // Check if the new direction matches with the original direction in the grid
                    int newCost = cost + ((grid[r][c] != i) ? 1 : 0);
                    if (newCost < minCosts[newR][newC]) {
                        minCosts[newR][newC] = newCost;
                        pq.add(new int[]{newCost, newR, newC});
                    }
                }
            }
        } return minCosts[m-1][n-1];
    }
    public static void main(String[] args) {
        System.out.println(minCostOpt(new int[][]{
                {1,1,1,1}, {2,2,2,2}, {1,1,1,1}, {2,2,2,2}}));
        System.out.println(minCostOpt(new int[][]{
                {1,1,3}, {3,2,2}, {1,1,4}}));
    }
}

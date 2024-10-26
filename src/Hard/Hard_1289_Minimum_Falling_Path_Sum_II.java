// 1289. Minimum Falling Path Sum II
package Hard;

import java.util.Arrays;

public class Hard_1289_Minimum_Falling_Path_Sum_II {
    // Recursion + Memoization
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int answer = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        for (int c = 0; c < n; c++)
            answer = Math.min(answer, solve(dp, grid, 0, c, n));
        return answer;
    }

    private static int solve(int[][] dp, int[][] grid, int r, int c, int n) {
        if (r == n) // reached the destination
            return 0;

        if (dp[r][c] != Integer.MAX_VALUE)
            return dp[r][c];

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            if (i != c)
                minSum = Math.min(minSum, grid[r][i] + solve(dp, grid, r + 1, i, n));

        dp[r][c] = minSum == Integer.MAX_VALUE ? grid[r][c] : minSum; ;
        return dp[r][c];
    }
    // Tabulation Approach
    public static int minFallingPathSumTabulation(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];
        for (int c=0; c<n; c++)
            dp[0][c] = grid[0][c];

        for (int r=1; r<n; r++) {
            for (int c=0; c<n; c++) {
                int result = Integer.MAX_VALUE;
                for (int k=0; k<n; k++) {
                    if (k != c)
                        result = Math.min(result, dp[r-1][k]);
                }
                dp[r][c] = grid[r][c] + result;
            }
        }
        // Now find the minimum in the last row
        int answer = Integer.MAX_VALUE;
        for (int v : dp[n-1])
            answer = Math.min(answer, v);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));  // Expected output: 13
        System.out.println(minFallingPathSum(new int[][]{{7}}));  // Expected output: 7
    }
}

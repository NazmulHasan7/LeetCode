// 63. Unique Paths II
package Medium;
import java.util.Arrays;

public class Medium_63_Unique_Paths_II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d,-1);
        return solve(dp, obstacleGrid, 0, 0, m, n);
    }
    private static int solve(int[][] dp, int[][] grid, int r, int c, int m, int n) {
        if (r >= m || c >= n ||grid[r][c] == 1)
            return 0;
        if (r == m-1 && c == n-1) return 1;
        if (dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = solve(dp, grid, r+1, c, m, n) + solve(dp, grid, r, c+1, m, n);
    }
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }
}

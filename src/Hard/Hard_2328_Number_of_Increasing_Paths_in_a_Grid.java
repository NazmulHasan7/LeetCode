// 2328. Number of Increasing Paths in a Grid
package Hard;
import java.util.Arrays;

public class Hard_2328_Number_of_Increasing_Paths_in_a_Grid {
    static int mod = (int)(1e9 + 7);
    public static int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, -1);

        int count = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                count = (count + solve(dp, grid, i, j, m, n, -1)) % mod;

        return count;
    }
    private static int solve(int[][] dp, int[][] grid, int r, int c, int m, int n, int prev) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] <= prev)
            return 0;
        if (dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = 1 + (
                solve(dp, grid, r+1, c, m, n, grid[r][c]) +
                        solve(dp, grid, r, c+1, m, n, grid[r][c]) +
                        solve(dp, grid, r-1, c, m, n, grid[r][c]) +
                        solve(dp, grid, r, c-1, m, n, grid[r][c])
        ) % mod;
    }
    public static void main(String[] args) {
        System.out.println(countPaths(new int[][]{{1,1},{3,4}}));
        System.out.println(countPaths(new int[][]{{1},{2}}));
    }
}

// 64. Minimum Path Sum
package Medium;
import java.util.Arrays;

public class Medium_64_Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, grid, 0, 0, m, n);
    }
    private static int solve(int[][] dp, int[][] grid, int r, int c, int m, int n) {
        if (r >= m || c >= n) return Integer.MAX_VALUE;
        if (r == m-1 && c == n-1) return grid[r][c];
        if (dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = grid[r][c] + Math.min(solve(dp,grid,r,c+1,m,n), solve(dp, grid, r+1, c, m, n));
    }
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}

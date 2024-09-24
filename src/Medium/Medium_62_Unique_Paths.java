// 62. Unique Paths
package Medium;
import java.util.Arrays;

public class Medium_62_Unique_Paths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d,-1);
        return solve(dp, 0, 0, m, n);
    }
    private static int solve(int[][] dp, int r, int c, int m, int n) {
        if (r >= m || c >= n) return 0;
        if (r == m-1 && c == n-1) return 1;
        if (dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = solve(dp, r+1, c, m, n) + solve(dp, r, c+1, m, n);
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePaths(3,2));
    }
}

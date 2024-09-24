// 329. Longest Increasing Path in a Matrix
package Hard;
import java.util.Arrays;

public class Hard_329_Longest_Increasing_Path_in_a_Matrix {
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        int maxPath = 1;

        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                maxPath = Math.max(maxPath, dfs(dp, matrix, i, j, -1, m, n));
        return maxPath;
    }
    private static int dfs(int[][] dp, int[][] matrix, int r, int c, int prev, int m, int n) {
        if (r >= m || c >= n || r < 0 || c < 0 || matrix[r][c] <= prev)
            return 0;
        if (dp[r][c] != -1) return dp[r][c];

        int max = 1;
        max = Math.max(max, 1 + dfs(dp, matrix, r+1, c, matrix[r][c], m, n));
        max = Math.max(max, 1 + dfs(dp, matrix, r-1, c, matrix[r][c], m, n));
        max = Math.max(max, 1 + dfs(dp, matrix, r, c+1, matrix[r][c], m, n));
        max = Math.max(max, 1 + dfs(dp, matrix, r, c-1, matrix[r][c], m, n));
        return dp[r][c] = max;
    }
    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        System.out.println(longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
    }
}

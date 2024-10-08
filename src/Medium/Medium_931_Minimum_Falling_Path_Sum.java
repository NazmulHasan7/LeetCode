// 931. Minimum Falling Path Sum
package Medium;
import java.util.Arrays;

public class Medium_931_Minimum_Falling_Path_Sum {
    // Time Complexity - O(m * n)
    // Space Complexity - O(m * n)
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        int answer = Integer.MAX_VALUE;
        for (int c=0; c<n; c++)
            answer = Math.min(answer, solve(dp, matrix, 0, c, m, n));
        return answer;
    }
    private static int solve(int[][] dp, int[][] matrix, int r, int c, int m, int n) {
        if (c < 0 || r > m || c >= n) // Out of bound
            return Integer.MAX_VALUE;
        if (r == m) return 0; // reached the bottom row

        if (dp[r][c] != Integer.MAX_VALUE) return dp[r][c];
        return dp[r][c] = matrix[r][c] + (Math.min(solve(dp, matrix, r+1, c, m, n),
                Math.min(solve(dp, matrix, r+1, c-1, m, n), solve(dp, matrix, r+1, c+1, m, n))));
    }
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        System.out.println(minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
    }
}

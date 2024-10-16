// 576. Out of Boundary Paths
package Medium;
import java.util.Arrays;

public class Medium_576_Out_of_Boundary_Paths {
    private static final int M = (int)1E9 + 7;
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for (int[][] dr : dp)
            for (int[] dc : dr)
                Arrays.fill(dc, -1);
        return solve(dp, m, n, maxMove, startRow, startColumn);
    }
    private static int solve(int[][][] dp, int m, int n, int maxMove, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) return 1; // out of bound
        if (maxMove == 0) return 0; // maximum move reached

        if (dp[r][c][maxMove] != -1) return dp[r][c][maxMove];

        long goLeft = solve(dp, m, n, maxMove-1, r, c-1) % M;
        long goRight = solve(dp, m, n, maxMove-1, r, c+1) % M;
        long goUp = solve(dp, m, n, maxMove-1, r-1, c) % M;
        long goDown = solve(dp, m, n, maxMove-1, r+1, c) % M;

        long result = (goLeft + goRight) % M;
        result = (result + goUp) % M;
        result = (result + goDown) % M;
        return dp[r][c][maxMove] = (int)result;
    }
    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
        System.out.println(findPaths(1,3,3,0,1));
    }
}

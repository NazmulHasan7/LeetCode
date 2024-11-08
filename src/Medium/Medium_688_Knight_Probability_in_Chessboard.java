// 688. Knight Probability in Chessboard
package Medium;
import java.util.Arrays;

public class Medium_688_Knight_Probability_in_Chessboard {
    // Recursion + Memoization -> O(n*n*k) for both time and space

    private static int[] rDir = {-2,-1,-2,-1, 1, 2,2,1};
    private static int[] cDir = {-1,-2, 1, 2,-2,-1,1,2};

    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n+1][n+1][k+1];
        for (double[][] dr : dp)
            for (double[] d : dr)
                Arrays.fill(d, -1.0);

        return solve(dp, row, column, k, n);
    }

    private static double solve(double[][][] dp, int r, int c, int k, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return 0.0; // out of bound

        if (k == 0) return 1.0; // the night remains on the board

        if (dp[r][c][k] != -1.0) return dp[r][c][k];

        double count = 0;
        for (int i=0; i<8; i++) {
            int newR = r + rDir[i];
            int newC = c + cDir[i];
            count += solve(dp, newR, newC, k-1, n);
        }
        return dp[r][c][k] = count / 8.0;
    }
    public static void main(String[] args) {
        System.out.println(knightProbability(3,2,0,0));
        System.out.println(knightProbability(1,0,0,0));
    }
}

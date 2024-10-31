// 2742. Painting the Walls
package Hard;
import java.util.Arrays;

public class Hard_2742_Painting_the_Walls {
    // Recursion + Memoization
    public static int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d,-1);

        return solve(dp, cost, time, 0, n, n);
    }
    private static int solve(int[][] dp, int[] cost, int[] time, int idx, int n, int remain) {
        if (remain <= 0)
            return 0; // Houses are painted

        if (idx == n) return (int) 1E9; // Out of bound
        if (dp[idx][remain] != -1) return dp[idx][remain];

        // When the paid painter is painting the house, if he takes x days
        // At that time free painter can paint x unit of houses for free
        // The free painter can paint 1 unit of house at 0 cost
        int paint = cost[idx] + solve(dp, cost, time, idx+1, n, remain-1-time[idx]);
        int skip = solve(dp, cost, time, idx+1, n, remain);

        return dp[idx][remain] = Math.min(paint, skip);
    }
    public static void main(String[] args) {
        System.out.println(paintWalls(new int[]{1,2,3,2}, new int[]{1,2,3,2}));
        System.out.println(paintWalls(new int[]{2,3,4,2}, new int[]{1,1,1,1}));
    }
}

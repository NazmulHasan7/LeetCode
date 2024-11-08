// 2787. Ways to Express an Integer as Sum of Powers
package Medium;
import java.util.Arrays;

public class Medium_2787_Ways_to_Express_an_Integer_as_Sum_of_Powers {
    // Recursion + Memoization
    private static final int MOD = (int) 1E9 + 7;
    // Knapsack DP
    public static int numberOfWays(int n, int x) {
        // for x = 3, max can be n^(1/x)
        // int i = (int) Math.pow(n, 1.0/x);

        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d,-1);
        return solve(n, x, n, dp) % MOD;
    }
    private static int solve(int n, int x, int i, int[][] dp) {
        if (n == 0) return 1; // A way found
        if (i <= 0) return 0; // unique positive integers

        if (dp[n][i] != -1) return dp[n][i];

        int skip = solve(n, x, i-1, dp) % MOD;
        int number = (int) Math.pow(i, x);
        int pick = 0;
        if (number <= n)
            pick = solve(n-number, x, i-1, dp) % MOD;

        return dp[n][i] = (skip + pick) % MOD;
    }

    // Tabulation
    public static int numberOfWaysTabulation(int n, int x) {
        int[] dp = new int[n+1];
        // dp[i] -> Number of ways to sum up to i
        dp[0] = 1;

        for (int i=1; i<=n; i++) {
            int number = (int) Math.pow(i, x);
            for (int j=n; j>=number; j--) {
                dp[j] = (dp[j] + dp[j-number]) % MOD;
            }
        } return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numberOfWays(10, 2));
        System.out.println(numberOfWays(4, 1));
    }
}

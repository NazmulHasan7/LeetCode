// 279. Perfect Squares
package Medium;
import java.util.Arrays;

public class Medium_279_Perfect_Squares {
    // Dynamic Programming -> Recursion + Memoization
    // Time Complexity: O(n * sqrt{n})
    // Space Complexity: O(n)
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, n);
    }
    private static int solve(int[] dp, int n) {
        if (n <= 0) return 0;
        if (dp[n] != -1) return dp[n];

        int minCount = Integer.MAX_VALUE;
        for (int i=1; i*i<=n; i++) {
            minCount = Math.min(minCount, 1 + solve(dp, n-i*i));
        }
        return dp[n] = minCount;
    }
    // Bottom-up Approach or Tabulation Method
    public static int numSquaresBottomUp(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[i] -> Minimum perfect squares needed to get i
        dp[0] = 0;
        for (int i=1; i<=n; i++) // from bottom to build up to n
            for (int j=1; j*j<=i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}

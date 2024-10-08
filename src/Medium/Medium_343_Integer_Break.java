// 343. Integer Break
package Medium;
import java.util.Arrays;

public class Medium_343_Integer_Break {
    // Recursion + Memoization -> TC O(n^2) & SC O(n)
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        // dp[i] -> maximum product we can get from number i
        Arrays.fill(dp, -1);
        return solve(dp, n);
    }
    private static int solve(int[] dp, int n) {
        if (n == 1) return 1; // breaking 1 make 0
        if (dp[n] != -1) return dp[n];

        int res = Integer.MIN_VALUE;
        for (int i=1; i<n; i++) {
            int product = i * Math.max(n-i, solve(dp,n-i));
            res = Math.max(res, product);
        }
        return dp[n] = res;
    }
    // Tabulation -> TC O(n^2) & SC O(n)
    public static int integerBreakTabulation(int n) {
        int[] dp = new int[n+1];
        // dp[i] -> Maximum product we can get from number i
        dp[1] = 1; // base case

        for (int number = 2; number <= n; number++) {
            for (int i = 1; i < number; i++) {
                dp[i] = Math.max(dp[i], i * Math.max(number-i, dp[number-i]));
            }
        } return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(10));
    }
}

// 70. Climbing Stairs
package Easy;
import java.util.Arrays;

public class Easy_70_Climbing_Stairs {
    private static int solve(int n, int[] dp) {
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        if (n == 0) return 1;
        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }
    public static int climbStairs(int n) {
        /* Time Complexity - O(2^n) - TLE
           if (n == 0) return 1;
           if (n < 0) return 0;
           return climbStairs(n-1) + climbStairs(n-2);
        */
        /* int[] dp = new int[n+1];
           Arrays.fill(dp, -1);
           return solve(n, dp);
        */
        if (n == 1 || n == 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}

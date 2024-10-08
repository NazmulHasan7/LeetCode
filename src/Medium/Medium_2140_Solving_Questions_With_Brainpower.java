// 2140. Solving Questions With Brainpower
package Medium;
import java.util.Arrays;

public class Medium_2140_Solving_Questions_With_Brainpower {
    // Recursion + Memoization
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, questions, 0, n);
    }
    private static long solve(long[] dp, int[][] questions, int idx, int n) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];

        long attend = questions[idx][0] + solve(dp, questions, idx+questions[idx][1]+1, n);
        long skip = solve(dp, questions, idx+1, n);
        return dp[idx] = Math.max(attend, skip);
    }
    // Tabulation
    public static long mostPointsTabulation(int[][] questions) {
        // Current task affects the future tasks -> Future tasks decide
        int n = questions.length;
        long[] dp = new long[n+1];
        // dp[i] -> Maximum points gained by Question from [i -> n-1]

        for (int i=n-1; i>=0; i--) {
            int points = questions[i][0];
            int brain = questions[i][1];
            long solve = points + (i + brain + 1 < n ? dp[i+brain+1] : 0);
            long skip = dp[i+1];
            dp[i] = Math.max(solve, skip);
        }
        return dp[0];
    }
    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
        System.out.println(mostPoints(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}));
    }
}

// 1402. Reducing Dishes
package Hard;
import java.util.Arrays;

public class Hard_1402_Reducing_Dishes {
    // Recursion + Memoization -> O(n^2) for both time and space
    public static int maxSatisfaction(int[] satisfaction) {
        // The chief can cook any food in 1 unit of time
        // To obtain the maximum value we need to sort the array
        // As sorting the array could maximize the like time coefficient value
        // Want to multiply maximum value with maximum time
        Arrays.sort(satisfaction);
        int n = satisfaction.length;

        int[][] dp = new int[n+1][n+2];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, satisfaction, 0, 1, n);
    }
    private static int solve(int[][] dp, int[] satisfaction, int idx, int time, int n) {
        if (idx >= n) return 0; // out of bound
        if (dp[idx][time] != -1) return dp[idx][time];

        int cook = satisfaction[idx] * time + solve(dp, satisfaction, idx+1, time+1, n);
        int skip = solve(dp, satisfaction, idx+1, time, n);
        return dp[idx][time] = Math.max(cook, skip);
    }

    // Optimized code
    public int maxSatisfactionOpt(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+2];

        for (int i=n-1; i>=0; i--) {
            for (int time=1; time<=n; time++) {
                int cook = satisfaction[i] * time + dp[i+1][time+1];
                int skip = dp[i+1][time];
                dp[i][time] = Math.max(cook, skip);
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1,-8,0,5,-9}));
        System.out.println(maxSatisfaction(new int[]{4,3,2}));
        System.out.println(maxSatisfaction(new int[]{-1,-4,-5}));
    }
}

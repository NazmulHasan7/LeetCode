// 1335. Minimum Difficulty of a Job Schedule
package Hard;
import java.util.Arrays;

public class Hard_1335_Minimum_Difficulty_of_a_Job_Schedule {
    // Recursion + Memoization -> TC O(n^2*d) SC O(n*d)
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[n+1][d+1];
        for (int[] x : dp) Arrays.fill(x, -1);

        if (n < d) return -1; // have to finish at least one job each day
        return solve(dp, jobDifficulty, 0, n, d);
    }
    private static int solve(int[][] dp, int[] jobDifficulty, int idx, int n, int day) {
        // Base Case -> if only one day is left, need to do all remaining tasks on that day
        if (day == 1) {
            int maxDifficulty = jobDifficulty[idx];
            for (int i=idx; i<n; i++)
                maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            return maxDifficulty;
        }

        if (dp[idx][day] != -1) return dp[idx][day];

        int leftMax = -1;
        int res = Integer.MAX_VALUE;

        for (int i=idx; i<=n-day; i++) {
            leftMax = Math.max(leftMax, jobDifficulty[i]);
            int rightMax = solve(dp, jobDifficulty, i+1, n, day-1);
            res = Math.min(res, leftMax + rightMax);
        }
        return dp[idx][day] = res;
    }
    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[]{6,5,4,3,2,1},2));
        System.out.println(minDifficulty(new int[]{9,9,9},4));
        System.out.println(minDifficulty(new int[]{1,1,1},3));
    }
}

// 746. Min Cost Climbing Stairs
package Easy;
import java.util.Arrays;

public class Easy_746_Min_Cost_Climbing_Stairs {
    private static int solve(int idx, int[] dp, int n, int[] cost) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];
        int jump1 = cost[idx] + solve(idx+1, dp, n, cost);
        int jump2 = cost[idx] + solve(idx+2, dp, n, cost);
        return dp[idx] = Math.min(jump1, jump2);
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, dp, n, cost), solve(1, dp, n, cost));
    }
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}

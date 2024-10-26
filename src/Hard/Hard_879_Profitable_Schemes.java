// 879. Profitable Schemes
package Hard;
import java.util.Arrays;

public class Hard_879_Profitable_Schemes {
    private static final int MOD = (int) 1E9 + 7;
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;

        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        for (int[][] dr : dp)
            for (int[] d : dr)
                Arrays.fill(d, -1);

        return solve(dp, 0, 0, 0, minProfit, n, group, profit, group.length) % MOD;
    }
    private static int solve(int[][][] dp, int idx, int members, int currProfit, int minProfit, int maxMembers, int[] group, int[] profit, int len) {
        if (members > maxMembers) return 0;

        if (idx == len) {
            if (currProfit >= minProfit)
                return 1; // A valid scheme found
            return 0; // Not a valid scheme
        }

        if (dp[idx][members][Math.min(currProfit, minProfit)] != -1)
            return dp[idx][members][Math.min(currProfit, minProfit)];

        // Skip the current crime
        int skip = solve(dp, idx + 1, members, currProfit, minProfit, maxMembers, group, profit, len) % MOD;
        // Commit the current crime
        int take = 0;
        if (members + group[idx] <= maxMembers) {
            take = solve(dp, idx + 1, members + group[idx],
                    currProfit + profit[idx], minProfit, maxMembers, group, profit, len) % MOD;
        }
        return dp[idx][members][Math.min(currProfit, minProfit)] = (take + skip) % MOD;
    }
    public static void main(String[] args) {
        System.out.println(profitableSchemes(5,3,new int[]{2,2}, new int[]{2,3}));
        System.out.println(profitableSchemes(10,5,new int[]{2,3,5}, new int[]{6,7,8}));
    }
}

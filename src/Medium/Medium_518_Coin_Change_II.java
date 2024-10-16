// 518. Coin Change II
package Medium;
import java.util.Arrays;

public class Medium_518_Coin_Change_II {
    // Recursion + Memoization -> TC O(n * amount) SC O(n * amount)
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, coins, 0, n, amount);
    }
    private static int solve(int[][] dp, int[] coins, int idx, int n, int amount) {
        if (idx >= n) return 0; // amount cannot be made
        if (amount == 0) return 1; // amount can be made

        if (dp[idx][amount] != -1) return dp[idx][amount];
        if (coins[idx] > amount) // current coin has bigger value try next one
            return solve(dp, coins, idx+1, n, amount);

        int take = solve(dp, coins, idx, n, amount - coins[idx]);
        int skip = solve(dp, coins, idx+1, n, amount);
        return dp[idx][amount] = take + skip;
    }
    public static int changeTabulation(int amount, int[] coins) {
        // Reference Tutorial -> https://www.youtube.com/watch?v=VSs8IRC-N8k
        int[] dp = new int[amount+1];
        dp[0] = 1; // there is one way of making amount 0, that is choosing no coins

        for (int coin : coins) {
            for (int j=coin; j<=amount; j++) {
                dp[j] = dp[j] + dp[j-coin];
            }
        } return dp[amount];
    }
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
        System.out.println(change(3, new int[]{2}));
        System.out.println(change(10, new int[]{10}));
    }
}

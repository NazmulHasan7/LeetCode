// 322. Coin Change
package Medium;
import java.util.Arrays;

public class Medium_322_Coin_Change {
    // Recursion + Memoization -> TC O(amount * n), SC O(amount)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int answer = solve(dp, coins, amount);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private static int solve(int[] dp, int[] coins, int amount) {
        if (amount == 0) return 0; // 0 coins needed
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(dp, coins, amount-coin);
            if (res != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins, 1+res); // add current coin
        }
        return dp[amount] = minCoins;
    }
    // Tabulation Approach -> TC -> O(amount * n) SC -> O(amount)
    public static int coinChangeTabulation(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 100);
        dp[0] = 0; // 0 coins required to make amount 0
        // dp[i] -> Minimum coins required to make the amount i

        for (int i=1; i<=amount; i++) {
            // int minCoins = Integer.MAX_VALUE; --> causes integer overflow
            int minCoins = amount + 100; // to avoid overflow
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minCoins = Math.min(minCoins, 1 + dp[i-coin]);
                }
            } dp[i] = minCoins;
        }
        return dp[amount] == amount + 100 ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange(new int[]{2},3));
        System.out.println(coinChange(new int[]{1},0));
    }
}

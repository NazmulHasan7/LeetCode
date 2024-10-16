// 309. Best Time to Buy and Sell Stock with Cooldown
package Medium;
import java.util.Arrays;

public class Medium_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    // Recursion + Memoization
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for (int[] d : dp) Arrays.fill(d, -1);
        // initially we have to buy the stock
        return solve(dp, prices, 0, n, true);
    }
    private static int solve(int[][] dp, int[] prices, int day, int n, boolean buy) {
        if (day >= n) return 0; // out of bound

        int buyIdx = buy ? 1 : 0;
        if (dp[day][buyIdx] != -1) return dp[day][buyIdx];

        int profit = 0;
        if (buy) {
            // We have two options -> buy the stock today or wait and buy in the coming days
            // Buying the stock today, means we have to sell it in the coming days
            // profit -> selling price - buying price
            int buyTodayProfit = solve(dp, prices, day+1, n, false) - prices[day];
            int buyInFutureProfit = solve(dp, prices, day+1, n, true);
            profit = Math.max(profit, Math.max(buyTodayProfit, buyInFutureProfit));
        } else {
            // Similarly we have two options, sell the stock today or sell it in the future
            int sellTodayProfit = prices[day] + solve(dp, prices, day+2, n, true); // 1 more day for cool down
            int sellInFutureProfit = solve(dp, prices, day+1, n, false);
            profit = Math.max(profit, Math.max(sellTodayProfit, sellInFutureProfit));
        }
        return dp[day][buyIdx] = profit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(maxProfit(new int[]{1}));
    }
}

// 188. Best Time to Buy and Sell Stock IV
package Hard;
import java.util.Arrays;

public class Hard_188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for (int[][] dr : dp)
            for (int[] dc : dr)
                Arrays.fill(dc, -1);
        return solve(dp, prices, 0, n, true, k);
    }
    private static int solve(int[][][] dp, int[] prices, int day, int n, boolean buy, int transactions) {
        if (transactions == 0 || day >= n)
            return 0; // transaction count reaches or out of bound

        int buyIdx = buy ? 1 : 0;
        if (dp[day][buyIdx][transactions] != - 1)
            return dp[day][buyIdx][transactions];

        int profit = 0;
        if (buy) {
            // two options -> buy the stock or skip (do not buy the stock)
            int buyStock = solve(dp, prices, day+1, n, false, transactions) - prices[day];
            int skip = solve(dp, prices, day+1, n, true, transactions);
            profit = Math.max(profit, Math.max(buyStock, skip));
        } else {
            // two options -> sell the stock or skip (do not sell the stock)
            int sellStock = prices[day] + solve(dp, prices, day+1, n, true, transactions-1);
            int skip = solve(dp, prices, day+1, n, false, transactions);
            profit = Math.max(profit, Math.max(sellStock, skip));
        }
        return dp[day][buyIdx][transactions] = profit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2,4,1}));
        System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}

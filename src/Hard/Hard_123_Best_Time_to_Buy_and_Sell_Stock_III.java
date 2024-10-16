// Hard 123. Best Time to Buy and Sell Stock III
package Hard;
import java.util.Arrays;

public class Hard_123_Best_Time_to_Buy_and_Sell_Stock_III {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for (int[][] dr : dp)
            for (int[] dc : dr)
                Arrays.fill(dc, -1);
        return solve(dp, prices, 0, n, true, 2);
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
    public int maxProfitOptimized(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;

        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}

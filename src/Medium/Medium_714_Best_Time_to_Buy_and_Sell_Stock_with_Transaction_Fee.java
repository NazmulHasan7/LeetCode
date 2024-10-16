// 714. Best Time to Buy and Sell Stock with Transaction Fee
package Medium;
import java.util.Arrays;

public class Medium_714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, prices, 0, n, true, fee);
    }
    private static int solve(int[][] dp, int[] prices, int idx, int n, boolean buy, int fee) {
        if (idx >= n) return 0;

        int buyIdx = buy ? 1 : 0;
        if (dp[idx][buyIdx] != -1) return dp[idx][buyIdx];
        int profit = 0;

        if (buy) {
            // have two options, buy the stock or not to buy the stock
            int buyStock = solve(dp, prices, idx+1, n, false, fee) - prices[idx];
            int skip = solve(dp, prices, idx+1, n, true, fee);
            profit = Math.max(profit, Math.max(buyStock, skip));
        } else {
            // have to options, sell the stock or not to sell the stock
            int sellStock = prices[idx] + solve(dp, prices, idx+1, n, true, fee) - fee;
            int skip = solve(dp, prices, idx+1, n, false, fee);
            profit = Math.max(profit, Math.max(sellStock, skip));
        }
        return dp[idx][buyIdx] = profit;
    }
    public int maxProfitOptimized(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for(int price : prices){
            buy = Math.max(buy, sell-price);
            sell = Math.max(sell, buy+price-fee);
        }
        return sell;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
        System.out.println(maxProfit(new int[]{1,3,7,5,10,3},3));
    }
}

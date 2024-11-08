// 122. Best Time to Buy and Sell Stock II
package Medium;
import java.util.Arrays;

public class Medium_122_Best_Time_to_Buy_and_Sell_Stock_II {
    // Recursion + Memoization
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, prices, 0, n, 1);
    }
    private static int solve(int[][] dp, int[] prices, int idx, int n, int buy) {
        if (idx >= n) return 0;

        if (dp[idx][buy] != -1) return dp[idx][buy];

        int answer = 0;
        if (buy == 1) {
            // Have two options, buy the stock or do not buy the stock
            int skip = solve(dp, prices, idx+1, n, buy);
            // since, buying the stock it's a debit
            int buyStock = solve(dp, prices, idx+1, n, 1-buy) - prices[idx];
            answer = Math.max(answer, Math.max(skip, buyStock));
        } else {
            // Have two options, sell the stock or hold the stock
            int hold = solve(dp, prices, idx+1, n, buy);
            // since selling the stock, it's a credit
            int sell = solve(dp, prices, idx+1, n, 1-buy) + prices[idx];
            answer = Math.max(answer, Math.max(hold, sell));
        }
        return dp[idx][buy] = answer;
    }
    // Optimized Approach
    public static int maxProfitOptimized(int[] prices) {
        int n = prices.length;
        int profit = 0;

        for (int i=0; i<n-1; i++) {
            if (prices[i+1] > prices[i])
                profit += prices[i+1] - prices[i];
        }
        return profit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}

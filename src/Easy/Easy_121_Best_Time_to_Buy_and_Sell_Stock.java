// 121. Best Time to Buy and Sell Stock
package Easy;

public class Easy_121_Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            // Buy the stock only if the current price is lower than current buying price
            if (prices[i] < buyPrice)
                buyPrice = prices[i];
            else // Check it maximum profit can be earned if we sell the stock in current price
                maxProfit = Math.max(maxProfit, prices[i]-buyPrice);
        } return maxProfit;
    }
    public static int maxProfitBetter(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}

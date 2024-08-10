// 1672. Richest Customer Wealth
package Easy;

public class Easy_1672_Richest_Customer_Wealth {
    public static int maximumWealth(int[][] accounts) {
        int richest = Integer.MIN_VALUE;
        int total;
        for (int[] account : accounts) {
            total = 0;
            for (int balance : account)
                total += balance;
            if (total > richest) richest = total;
        }
        return richest;
    }
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        System.out.println(maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}

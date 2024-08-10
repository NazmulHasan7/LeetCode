// 2706. Buy Two Chocolates
package Easy;

public class Easy_2706_Buy_Two_Chocolates {
    public static int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price <= min) {
                secondMin = min;
                min = price;
            } else if (price < secondMin)
                secondMin = price;
        }
        int leftover = money - min - secondMin;
        return leftover >= 0 ? leftover : money;
    }
    public static void main(String[] args) {
        System.out.println(buyChoco(new int[] {1,2,2}, 3));
        System.out.println(buyChoco(new int[] {3,2,3}, 3));
    }
}

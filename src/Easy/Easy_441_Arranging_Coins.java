// 441. Arranging Coins
package Easy;

public class Easy_441_Arranging_Coins {
    public static int arrangeCoins(int n) {
        int start = 0, end = n;
        long sum, mid;
        while (start<=end) {
            mid = start + (end - start) / 2;
            sum = mid * (mid + 1) / 2;
            if (sum > n) end = (int) mid - 1;
            else if (sum < n) start = (int) mid + 1;
            else return (int) mid;
        } return end;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(10));
    }
}

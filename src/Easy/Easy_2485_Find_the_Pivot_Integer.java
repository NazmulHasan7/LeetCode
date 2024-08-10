// 2485. Find the Pivot Integer
package Easy;

public class Easy_2485_Find_the_Pivot_Integer {
    public static int pivotInteger(int n) {
        int sum = 0;
        int total = (n * (n+1)) / 2;
        for (int i=1; i<=n; i++) {
            sum += i;
            if (sum == (total - sum + i)) return i;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(0));
        System.out.println(pivotInteger(4));
    }
}

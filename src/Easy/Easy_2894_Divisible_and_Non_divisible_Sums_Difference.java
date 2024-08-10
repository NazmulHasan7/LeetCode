// 2894. Divisible and Non-divisible Sums Difference
package Easy;

public class Easy_2894_Divisible_and_Non_divisible_Sums_Difference {
    public static int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i=1; i<=n; i++) {
            if (i % m == 0) num2 += i;
            else num1 += i;
        } return num1 - num2;
    }
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
        System.out.println(differenceOfSums(5, 6));
        System.out.println(differenceOfSums(5, 1));
    }
}

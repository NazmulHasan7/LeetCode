// 1281. Subtract the Product and Sum of Digits of an Integer
package Easy;

public class Easy_1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    public static int subtractProductAndSum(int n) {
        int prod = 1, sum = 0, dg;
        while (n != 0) {
            dg = n % 10;
            n /= 10;
            sum += dg;
            prod *= dg;
        } return prod - sum;
    }
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }
}

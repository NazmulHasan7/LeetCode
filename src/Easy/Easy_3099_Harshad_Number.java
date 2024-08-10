// 3099. Harshad Number
package Easy;

public class Easy_3099_Harshad_Number {
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0, num = x;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        } return (num % sum == 0) ? sum : -1;
    }
    public static void main(String[] args) {
        System.out.println(sumOfTheDigitsOfHarshadNumber(18));
        System.out.println(sumOfTheDigitsOfHarshadNumber(23));
    }
}

// 202. Happy Number
package Easy;
import java.util.HashSet;

public class Easy_202_Happy_Number {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            n = sumOfSquaredDigits(n);
            if (!set.add(n)) return false;
        } return true;
    }
    private static int sumOfSquaredDigits(int n) {
        int sum = 0, digit;
        while (n != 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        } return sum;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}

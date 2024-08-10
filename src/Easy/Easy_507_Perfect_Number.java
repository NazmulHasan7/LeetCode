// 507. Perfect Number
package Easy;

public class Easy_507_Perfect_Number {
    public static boolean checkPerfectNumber(int num) {
        // Divisors of 28 are 1, 2, 4 | 7, 14
        if (num == 1) return false;
        int sum = 1;
        for (int i=2; i*i<=num; i++)
            // 2 + 14, 4 + 7
            if (num % i == 0) sum += i + num / i;
        return num == sum;
    }
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
        System.out.println(checkPerfectNumber(7));
    }
}

// 2457. Minimum Addition to Make Integer Beautiful
package Medium;

public class Medium_2457_Minimum_Addition_to_Make_Integer_Beautiful {
    public static long makeIntegerBeautiful(long n, int target) {
        long answer = 0;
        long factor = 10;

        while (sumOfDigits(n) > target) {
            long rem = n % factor;
            long add = factor - rem;
            n += add;
            answer += add;
            factor *= 10;
        }
        return answer;
    }
    private static long sumOfDigits(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(16,6));
        System.out.println(makeIntegerBeautiful(467,6));
        System.out.println(makeIntegerBeautiful(1,1));
    }
}

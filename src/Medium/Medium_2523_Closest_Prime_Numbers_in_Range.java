// 2523. Closest Prime Numbers in Range
package Medium;
import java.util.Arrays;

public class Medium_2523_Closest_Prime_Numbers_in_Range {
    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        int sqrtNum = (int) Math.sqrt(num);
        for (int i=2; i<=sqrtNum; i++)
            if (num % i == 0)
                return false;
        return true;
    }
    // TC -> O(n * sqrt(n)), SC -> O(1)
    public static int[] closestPrimes(int left, int right) {
        int[] answer = {-1, -1};
        int lastPrime = -1;

        while (left <= right) {
            if (isPrime(left)) {
                if (lastPrime != -1) {
                    if (answer[0] == -1 || left - lastPrime < answer[1] - answer[0]) {
                        answer[0] = lastPrime;
                        answer[1] = left;
                        if (left - lastPrime <= 2)
                            return answer;
                    }
                } lastPrime = left;
            } left++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19)));
        System.out.println(Arrays.toString(closestPrimes(4, 6)));
        System.out.println(Arrays.toString(closestPrimes(19, 31)));
    }
}

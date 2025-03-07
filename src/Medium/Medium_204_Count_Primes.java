// 204. Count Primes
package Medium;
import java.util.Arrays;

public class Medium_204_Count_Primes {
    // Sieve of Eratosthenes
    public static int countPrimes(int n) {
        if (n <= 1) return 0;

        boolean[] isPrime = new boolean[n]; // strictly less than n
        Arrays.fill(isPrime, true); // initially all are marked as prime
        isPrime[0] = false; // 0 and 1 are not prime
        isPrime[1] = false;

        int count = n - 2;
        int sqrt = (int) Math.sqrt(n);

        for (int i=2; i<=sqrt; i++) {
            if (isPrime[i]) {
                // mark the multiples of i as false
                for (int j=i*i; j<n; j+=i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count--;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
    }
}

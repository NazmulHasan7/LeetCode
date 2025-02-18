// 3115. Maximum Prime Difference
package Medium;

public class Medium_3115_Maximum_Prime_Difference {
    public int maximumPrimeDifference(int[] nums) {
        // First and last prime number indices
        int firstPrime = -1, lastPrime = -1;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (isPrime(nums[i])) {
                // Found the first prime, now look for the last one
                for (int j=n-1; j>=i; j--)
                    if (isPrime(nums[j]))
                        return j - i;
            }
        }
        // No prime numbers found
        return 0;
    }
    private boolean isPrime(int num) {
        if (num == 1) return false;
        int sqrt = (int)Math.sqrt(num);
        for (int i=2; i<=sqrt; i++)
            if (num % i == 0)
                return false;
        return true;
    }
}

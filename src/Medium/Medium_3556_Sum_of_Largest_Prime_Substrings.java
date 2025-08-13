// 3556. Sum of Largest Prime Substrings
package Medium;

public class Medium_3556_Sum_of_Largest_Prime_Substrings {
    public static long sumOfLargestPrimes(String s) {
        int n = s.length();
        long max1 = 0, max2 = 0, max3 = 0;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                long number = Long.parseLong(s.substring(i, j+1));
                if (number > 1 && isPrime(number)) {
                    if (number != max1 && number != max2 && number != max3) {
                        if (number > max1) {
                            max3 = max2;
                            max2 = max1;
                            max1 = number;
                        } else if (number > max2) {
                            max3 = max2;
                            max2 = number;
                        } else if (number > max3) {
                            max3 = number;
                        }
                    }
                }
            }
        } return max1 + max2 + max3;
    }
    private static boolean isPrime(long number) {
        int x = (int)Math.sqrt(number);
        for (int i=2; i<=x; i++)
            if (number % i == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(sumOfLargestPrimes("12234"));
        System.out.println(sumOfLargestPrimes("111"));
    }
}

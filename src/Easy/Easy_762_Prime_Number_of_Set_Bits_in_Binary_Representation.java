// 762. Prime Number of Set Bits in Binary Representation
package Easy;

public class Easy_762_Prime_Number_of_Set_Bits_in_Binary_Representation {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i=2; i*i<=n; i++)
            if (n % i == 0) return false;
        return true;
    }
    public static int countPrimeSetBits(int left, int right) {
        int count = 0, bitCount;
        for (int i=left; i<=right; i++) {
            bitCount = Integer.bitCount(i);
            if (isPrime(bitCount)) count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
    }
}

// 342. Power of Four
package Easy;

public class Easy_342_Power_of_Four {
    public static boolean isPowerOfFour(int n) {
        return  (n > 0) &&
                ((n & (n-1)) == 0) &&
                ((n - 1) % 3 == 0);
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(-16));
        System.out.println(isPowerOfFour(4));
    }
}

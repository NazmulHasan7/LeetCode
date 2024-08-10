// 231. Power of Two
package Easy;

public class Easy_231_Power_of_Two {
    public static boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n-1)) == 0);
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(-8));
        System.out.println(isPowerOfTwo(8));
    }
}

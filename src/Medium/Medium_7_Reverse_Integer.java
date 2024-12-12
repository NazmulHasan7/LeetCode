// 7. Reverse Integer
package Medium;

public class Medium_7_Reverse_Integer {
    public static int reverse(int x) {
        int temp = Math.abs(x);
        long rev = 0;
        while (temp > 0) {
            int rem = temp % 10;
            rev = (rev * 10) + rem;
            temp /= 10;
        }
        if (rev > Integer.MAX_VALUE) return 0;
        return (int) (x < 0 ? -1 * rev : rev);
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}

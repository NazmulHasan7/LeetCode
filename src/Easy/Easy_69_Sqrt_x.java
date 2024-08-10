// 69. Sqrt(x)
package Easy;

public class Easy_69_Sqrt_x {
    public static int mySqrt(int x) {
        int sqrt = -1;
        int start = 0, end = x, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid > x) end = mid - 1;
            else if (mid * mid < x) {
                sqrt = mid;
                start = mid + 1;
            } else return mid;
        } return sqrt;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }
}

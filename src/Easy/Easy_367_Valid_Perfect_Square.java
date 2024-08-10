// 367. Valid Perfect Square
package Easy;

public class Easy_367_Valid_Perfect_Square {
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return (sqrt * sqrt == num);
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}

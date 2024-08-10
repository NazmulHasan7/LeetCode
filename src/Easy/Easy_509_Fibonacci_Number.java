// 509. Fibonacci Number
package Easy;

public class Easy_509_Fibonacci_Number {
    public static int fibRecursion(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fibRecursion(n-1) + fibRecursion(n-2);
    }
    public static int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int prev1 = 0, prev2 = 1, current = 0;
        for (int i=2; i<=n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        } return current;
    }
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }
}

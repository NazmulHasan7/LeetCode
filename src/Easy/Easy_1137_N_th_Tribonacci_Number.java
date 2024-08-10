// 1137. N-th Tribonacci Number
package Easy;

public class Easy_1137_N_th_Tribonacci_Number {
    public static int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
    public static int tribonacciBetter(int n) {
        if (n <= 2)
            return (n == 0) ? 0 : 1;
        int t1 = 0, t2 = 1, t3 = 1, result = 0;
        for (int i=3; i<=n; i++) {
            result = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = result;
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
        System.out.println(tribonacciBetter(4));
        System.out.println(tribonacciBetter(25));
    }
}

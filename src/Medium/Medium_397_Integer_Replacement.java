// 397. Integer Replacement
package Medium;
import java.util.HashMap;

public class Medium_397_Integer_Replacement {
    // Recursion + Memoization
    public static int integerReplacement(int n) {
        return solve(n, new HashMap<>());
    }
    private static int solve(int n, HashMap<Integer, Integer> dp) {
        if (n == 1) return 0;
        if (n < 1) return Integer.MAX_VALUE;
        if (dp.containsKey(n)) return dp.get(n);

        int count = 0;
        if ((n & 1) == 1) {
            // odd number
            count = 1 + Math.min(solve(n-1,dp), solve(n+1,dp));
        } else {
            count = 1 + solve(n/2,dp);
        }
        dp.put(n, count);
        return count;
    }

    // Greedy Approach
    public static int integerReplacementOpt(int n) {
        long num = n;
        int answer = 0;

        while (num != 1) {
            if ((num % 2) == 0) {
                num /= 2;
            } else {
                if (num == 3 || (num % 4) == 1)
                    num -= 1;
                else num += 1;
            }
            answer++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));
    }
}

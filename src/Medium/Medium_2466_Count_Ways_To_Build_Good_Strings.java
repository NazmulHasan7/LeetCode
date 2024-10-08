// 2466. Count Ways To Build Good Strings
package Medium;
import java.util.Arrays;

public class Medium_2466_Count_Ways_To_Build_Good_Strings {
    // Recursion + Memoization approach
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        return (int) (solve(dp, low, high, zero, one, 0) % (1E9 + 7));
    }
    private static int solve(int[] dp, int low, int high, int zero, int one, int len) {
        if (len > high) return 0;
        if (dp[len] != -1) return dp[len];

        int add = 0;
        if (len >= low) add++;

        int addZero = solve(dp, low, high, zero, one, len + zero);
        int addOne = solve(dp, low, high, zero, one, len + one);
        return dp[len] = (int) ((add + addZero + addOne) % (1E9 + 7));
    }
    // Tabulation approach
    public static int countGoodStringsTabulation(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1; // number of good strings of length 0 is 1 -> empty string

        for (int len = 1; len <= high; len++) {
            if (len >= zero) dp[len] = (dp[len] + dp[len - zero]) % 1000000007;
            if (len >= one) dp[len] = (dp[len] + dp[len - one]) % 1000000007;
        }
        int answer = 0;
        for (int i = low; i <= high; i++)
            answer = (answer + dp[i]) % 1000000007;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(countGoodStrings(3, 3, 1, 1));
        System.out.println(countGoodStrings(2, 3, 1, 2));
    }
}

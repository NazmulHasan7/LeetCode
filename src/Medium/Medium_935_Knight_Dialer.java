// 935. Knight Dialer
package Medium;
import java.util.Arrays;

public class Medium_935_Knight_Dialer {
    // Recursion + Memoization
    // -> TC O(10 * n), SC O(10 * n)
    private static final int MOD = 1_000_000_007;
    private static final int[][] MOVES = {
            {4, 6},    // 0
            {6, 8},    // 1
            {7, 9},    // 2
            {4, 8},    // 3
            {0, 3, 9}, // 4
            {},        // 5
            {0, 1, 7}, // 6
            {2, 6},    // 7
            {1, 3},    // 8
            {2, 4}     // 9
    };
    public static int knightDialer(int n) {
        int answer = 0;
        int[][] dp = new int[n+1][10];
        for (int[] d : dp) Arrays.fill(d,-1);

        for (int cell = 0; cell <= 9; cell++)
            answer = (answer + solve(dp, n-1, cell)) % MOD;
        return answer;
    }
    private static int solve(int[][] dp, int n, int cell) {
        if (n == 0) return 1; // A number of length n found
        if (dp[n][cell] != -1) return dp[n][cell];

        int res = 0;
        for (int nextCell : MOVES[cell])
            res = (res + solve(dp,n-1, nextCell)) % MOD;

        return dp[n][cell] = res;
    }

    // Tabulation Approach
    public static int knightDialerTabulation(int n) {
        int[][] dp = new int[n+1][10];
        // dp[i][j] -> Total number of distinct phone number of length i when at cell j
        Arrays.fill(dp[0],1); // remember base case n == 0 -> 1

        for (int i=1; i<=n-1; i++) {
            for (int cell = 0; cell <= 9; cell++) {
                int result = 0;
                for (int nextCell : MOVES[cell]) {
                    result = (result + dp[i-1][nextCell]) % MOD;
                }
                dp[i][cell] = result;
            }
        }
        int answer = 0;
        for (int count : dp[n-1])
            answer = (answer + count) % MOD;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3131));
    }
}

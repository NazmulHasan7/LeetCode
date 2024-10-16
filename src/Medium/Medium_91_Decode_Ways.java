// 91. Decode Ways
package Medium;
import java.util.Arrays;

public class Medium_91_Decode_Ways {
    // Recursion + Memoization -> O(n)
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, s.toCharArray(), 0, n);
    }
    private static int solve(int[] dp, char[] crr, int i, int n) {
        if (i == n) return 1; // one decoding way found
        if (crr[i] == '0') return 0;

        if (dp[i] != -1) return dp[i];

        // try splitting in the current index
        int count = solve(dp, crr, i+1, n);
        if (i+1 < n) {
            if (crr[i] == '1' || crr[i] == '2' && crr[i+1] <= '6')
                count += solve(dp, crr, i+2, n);
        }
        return dp[i] = count;
    }
    // Tabulation Approach
    public static int numDecodingsTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        // dp[i] -> decoding ways from index i to n
        dp[n] = 1;

        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < n) {
                    if (s.charAt(i) == 1 || s.charAt(i) == 2 && s.charAt(i + 1) <= 6)
                        dp[i] = dp[i + 2];
                }
            }
        } return dp[0];
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("06"));
    }
}

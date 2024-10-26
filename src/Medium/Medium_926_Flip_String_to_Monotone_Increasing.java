// 926. Flip String to Monotone Increasing
package Medium;
import java.util.Arrays;

public class Medium_926_Flip_String_to_Monotone_Increasing {
    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][2];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(dp, s.toCharArray(), 0, 0, n);
    }
    private static int solve(int[][] dp, char[] crr, int idx, int prev, int n) {
        if (idx >= n) return 0; // out of bound

        if (dp[idx][prev] != -1) return dp[idx][prev];

        int flip = Integer.MAX_VALUE;
        int noFlip = Integer.MAX_VALUE;

        if (crr[idx] == '0') {
            // current character is 0
            if (prev == 1) {
                // since the previous character is 1 and current is 0,
                // we have only one option to flip to maintain the increasing order
                flip = 1 + solve(dp, crr, idx + 1, 1, n);
            } else {
                // we have two options, either flip it or not to flip the current char
                noFlip = solve(dp, crr, idx + 1, 0, n);
                flip = 1 + solve(dp, crr, idx+1, 1, n);
            }
        } else { // current character is 1
            if (prev == 1) {
                // current and prev both 1, we have no option to flip
                noFlip = solve(dp, crr, idx+1, 1, n);
            } else {
                // current is 1 and prev is 0, we can either flip or skip
                flip = 1 + solve(dp, crr, idx+1, 0, n);
                noFlip = solve(dp, crr, idx+1, 1 , n);
            }
        }
        return dp[idx][prev] = Math.min(flip, noFlip);
    }
    // Optimized Approach
    public static int minFlipsMonoIncrOptimized(String s) {
        int countOne = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                countOne++;
            } else {
                // flip the current char + number of flips required to make the string monotonic increasing until previous index
                // or flip all the 1's till now
                res = Math.min(countOne, 1 + res);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }
}

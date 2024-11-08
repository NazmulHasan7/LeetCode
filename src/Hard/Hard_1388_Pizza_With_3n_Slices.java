// 1388. Pizza With 3n Slices
package Hard;
import java.util.Arrays;

public class Hard_1388_Pizza_With_3n_Slices {
    /*
        Given a pizza with 3n slices of varying sizes arranged in a circle,
        you and your friends, Alice and Bob, take turns picking slices according to the following rules:

        - You pick any pizza slice first.
        - Alice picks the next slice in the anti-clockwise direction from your chosen slice.
        - Bob picks the next slice in the clockwise direction from your chosen slice.
        - This process repeats until all slices are picked.

        Each player has exactly n turns (since the total number of slices is 3n, divided evenly among 3 players).

        Example:
        If you pick the first slice (index 0),
        - Alice picks the slice at the last index (n - 1),
        - Bob picks the slice at index 1.

        The process continues, with the same pattern for subsequent rounds.

        Key Observation:
        - You only need to consider subarrays of slices and exclude overlapping selections.
        - The problem can be broken down by considering the maximum sum of slices you can pick when:
          1. The first slice is chosen, excluding the last slice (circular array constraint).
          2. The last slice is considered, excluding the first slice.

        This ensures that you only calculate the maximum possible sum without exceeding the constraint of choosing
        more than n slices in total, and it avoids revisiting the circular wraparound edge case.
    */

    // Recursion + Memoization
    public static int maxSizeSlices(int[] slices) {
        int _3n = slices.length;
        int n = _3n/3;

        int[][] dp = new int[_3n+1][n+1];
        for (int[] d : dp) Arrays.fill(d, -1);

        // As I take the first one, 2nd and last slices are taken by others
        // So, I cannot take the last one
        int takeFirst = solve(dp, slices, 0, _3n-2, n);
        // As I do not take the first one, I have the option to take the last one

        for (int[] d : dp) Arrays.fill(d, -1);
        int skipFirst = solve(dp, slices, 1, _3n-1, n);

        return Math.max(takeFirst, skipFirst);
    }

    private static int solve(int[][] dp, int[] slices, int idx, int end, int n) {
        if (n == 0 || idx > end) return 0;

        if (dp[idx][n] != -1) return dp[idx][n];

        // If I take the current slice, we cannot take the next slice
        int take = slices[idx] + solve(dp, slices, idx+2, end, n-1);
        // If I do not take the current slice, I can take the next one
        int skip = solve(dp, slices, idx+1, end, n);

        return dp[idx][n] = Math.max(take, skip);
    }

    // Tabulation - Bottom up
    public static int maxSizeSlicesOpt(int[] slices) {
        int _3n = slices.length;
        int n = _3n/3;

        // Case 1 -> pick the first one
        int[][] dp1 = new int[_3n+1][n+1];
        // dp[i][j] -> Maximum sum of slices till ith index with j slices left to pick
        for (int i=_3n-2; i>=0; i--) {
            for (int j=1; j<=n; j++) {
                int take = slices[i] + dp1[i+2][j-1];
                int skip = dp1[i+1][j];
                dp1[i][j] = Math.max(take, skip);
            }
        }
        int case1 = dp1[0][n];


        // Case 2 -> do not pick the first one
        int[][] dp2 = new int[_3n+1][n+1];
        // dp[i][j] -> Maximum sum of slices till ith index with j slices left to pick
        for (int i=_3n-1; i>=1; i--) {
            for (int j=1; j<=n; j++) {
                int take = slices[i] + (i+2 < _3n ? dp2[i+2][j-1] : 0);
                int skip = dp2[i+1][j];
                dp2[i][j] = Math.max(take, skip);
            }
        }
        int case2 = dp2[1][n];

        return Math.max(case1, case2);
    }
    public static void main(String[] args) {
        System.out.println(maxSizeSlices(new int[]{1,2,3,4,5,6}));
        System.out.println(maxSizeSlices(new int[]{8,9,8,6,1,1}));
        System.out.println(maxSizeSlicesOpt(new int[]{1,2,3,4,5,6}));
        System.out.println(maxSizeSlicesOpt(new int[]{8,9,8,6,1,1}));
    }
}

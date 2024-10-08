// 516. Longest Palindromic Subsequence
package Medium;
import java.util.Arrays;

public class Medium_516_Longest_Palindromic_Subsequence {
    // Recursion + Memoization -> TC & SC -> O(n^2)
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d,-1);
        return solve(dp, s.toCharArray(), 0, n-1);
    }
    private static int solve(int[][] dp, char[] crr, int i, int j) {
        if (i > j) return 0; // invalid indices
        if (i == j) return 1; // both pointing to the same index

        if (dp[i][j] != -1) return dp[i][j];

        if (crr[i] == crr[j]) // match found
            return dp[i][j] = 2 + solve(dp, crr, i+1, j-1);

        return dp[i][j] = Math.max(solve(dp, crr, i+1, j), solve(dp, crr, i, j-1));
    }
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}

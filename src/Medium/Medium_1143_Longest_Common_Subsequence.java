// 1143. Longest Common Subsequence
package Medium;
import java.util.Arrays;

public class Medium_1143_Longest_Common_Subsequence {
    // Recursive + Memoization
    // LCS -> Longest Common Subsequence
    public static int longestCommonSubsequence(String text1, String text2) {
        // Approach -> Compare to characters of current position
        // Max of (Try moving index of text1, Try moving index of text2)
        // TC without memoization -> O(2^n1 * 2^n2)
        // TC with memoization -> O(n1 * n2)
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, text1.toCharArray(), text2.toCharArray(), 0, 0, n1, n2);
        // return solveBottomUp(text1.toCharArray(), text2.toCharArray(), n1, n2);
    }
    private static int solve(int[][] dp, char[] t1, char[] t2, int i, int j, int m, int n) {
        if (i >= m || j >= n) return 0; // out of bound
        if (dp[i][j] != -1) return dp[i][j]; // Already solved sub-problem

        if (t1[i] == t2[j]) // matches, move both indices
            return dp[i][j] = 1 + solve(dp, t1, t2, i+1, j+1, m, n);

        return dp[i][j] = Math.max(solve(dp, t1, t2, i+1, j, m, n), solve(dp, t1, t2, i, j+1, m, n));
    }
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
    private static int solveBottomUp(char[] t1, char[] t2, int m, int n) {
        // dp[i][j] -> the longest common subsequence till t1 of length i, t2 of length j
        // dp[0][1] -> t1 of length 0, t2 of length 1 => 0

        int[][] dp = new int[m+1][n+1];
        // first row will be 0, as any string with length 0 would lead to 0 as result
        Arrays.fill(dp[0], 0);
        // first column will be 0, as any string with length 0 would lead to 0 as result
        for (int r=0; r<m+1; r++) dp[r][0] = 0;

        for (int i=1; i<m+1; i++) {
            for (int j=1; j<n+1; j++) {
                if (t1[i-1] == t2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        } return dp[m][n];
    }
}

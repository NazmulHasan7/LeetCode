// 712. Minimum ASCII Delete Sum for Two Strings
package Medium;
import java.util.Arrays;

public class Medium_712_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    // Recursion + Memoization approach
    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, s1.toCharArray(), s2.toCharArray(), 0, 0, n, m);
    }
    private static int solve(int[][] dp, char[] s1, char[] s2, int i, int j, int n, int m) {
        if (i >= n && j >= m) return 0; // both out of bound

        if (i == n) // the remaining chars of s2 needs to be deleted
            return dp[i][j] = s2[j] + solve(dp, s1, s2, i, j+1, n, m);

        if (j == m) // the remaining chars of s1 needs to be deleted
            return dp[i][j] = s1[i] + solve(dp, s1, s2, i+1, j, n, m);

        if (dp[i][j] != -1) return dp[i][j];

        if (s1[i] == s2[j]) // no deletion needed
            return solve(dp, s1, s2, i+1, j+1, n, m);

        int deleteFromS1 = s1[i] + solve(dp, s1, s2, i+1, j, n, m);
        int deleteFromS2 = s2[j] + solve(dp, s1, s2, i, j+1, n, m);
        return dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
    }
    // Tabulation approach
    public static int minimumDeleteSumTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // dp[i][j] -> minimum ASCII delete sun to make s1 of length i equal to s2 of length j
        int[][] dp = new int[n+1][m+1];

        // If one string is empty, the cost is to delete the chars of other string
        for (int i=1; i<=n; i++)
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);

        for (int j=1; j<=m; j++)
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no deletion needed
                } else {
                    dp[i][j] = Math.min(
                            dp[i-1][j] + s1.charAt(i-1),
                            dp[i][j-1] + s2.charAt(j-1)
                    );
                }
            }
        } return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
// 583. Delete Operation for Two Strings
package Medium;
import java.util.Arrays;

public class Medium_583_Delete_Operation_for_Two_Strings {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        return solve(dp, word1.toCharArray(), word2.toCharArray(), 0, 0, m, n);
    }
    private static int solve(int[][] dp, char[] w1, char[] w2, int i, int j, int m, int n) {
        if (i >= m) return n - j; // Need to delete remaining characters of word2
        if (j >= n) return m - i; // Need to delete remaining characters of word1
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        if (w1[i] == w2[j]) // If characters are the same, move to next
            return dp[i][j] = solve(dp, w1, w2, i + 1, j + 1, m, n);

        int delete1 = solve(dp, w1, w2, i + 1, j, m, n); // Delete a character from word1
        int delete2 = solve(dp, w1, w2, i, j + 1, m, n); // Delete a character from word2

        return dp[i][j] = 1 + Math.min(delete1, delete2); // Take the minimum steps + 1 deletion step
    }

    // Bottom-up Approach
    public static int minDistanceBottomUp(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        // dp[i][j] -> Minimum distance at dp[i][j]

        // Deleting all characters from word1 to match an empty word2
        for (int i=0; i<=m; i++) dp[i][0] = i;

        // Deleting all characters from word2 to match an empty word1
        for (int j=0; j<=n; j++) dp[0][j] = j;

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    // If characters match, no deletion is needed
                    dp[i][j] = dp[i-1][j-1];
                else
                    // Take the minimum of deleting from either word1 or word2
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        } return dp[m][n];
    }
    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("leetcode", "etco"));
    }
}

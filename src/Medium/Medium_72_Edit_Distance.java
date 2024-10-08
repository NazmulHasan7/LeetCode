// 72. Edit Distance
package Medium;
import java.util.Arrays;

public class Medium_72_Edit_Distance {
    // Recursion + Memoization approach
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, word1.toCharArray(), word2.toCharArray(), 0, 0, n, m);
    }
    private static int solve(int[][] dp, char[] w1, char[] w2, int i, int j, int s1, int s2) {
        if (i == s1) // ab, abc -> need to remove the extra chars from word 2
            return s2 - j;
        if (j == s2) // abc, ab -> need to remove the extra chars from word 1
            return s1 - i;

        if (dp[i][j] != -1) return dp[i][j];
        // Match found, no operation needed
        if (w1[i] == w2[j]) return solve(dp, w1, w2, i+1, j+1, s1, s2);

        // insert operation -> insert the current char of w2, so i in same position, j moves to next
        int insert = 1 + solve(dp, w1, w2, i, j+1, s1, s2);
        // remove operation -> remove the current char from w1, so i moves to the next, j remains in the same position
        int remove = 1 + solve(dp, w1, w2, i+1, j, s1, s2);
        // replace operation -> replaces the current char of w2 with the current char of w1, both pointer moves next
        int replace = 1 + solve(dp, w1, w2, i+1, j+1, s1, s2);

        return dp[i][j] = Math.min(insert, Math.min(remove, replace));
    }
    // Tabulation approach
    public static int minDistanceTabulation(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        // dp[i][j] -> minimum operations required to make word1 of length i equal to word2 of length j
        for (int i=0; i<=n; i++) // when word2 is empty
            dp[i][0] = i; // Deleting all characters from word1

        for (int j=0; j<=m; j++) // when word1 is empty
            dp[0][j] = j; // Inserting all characters to word1

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; // characters matches, no operations needed
                } else {
                    int insert = dp[i][j-1]; // insert in word1, so j moves
                    int remove = dp[i-1][j]; // remove from word1, so i moves
                    int replace = dp[i-1][j-1]; // now both matches, move both pointers
                    dp[i][j] = 1 + Math.min(insert, Math.min(remove, replace));
                }
            }
        } return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}

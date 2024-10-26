// 10. Regular Expression Matching
package Hard;

public class Hard_10_Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // dp array for memoization with -1 as uninitialized
        Boolean[][] dp = new Boolean[sLen + 1][pLen + 1];
        return solve(dp, s, p, 0, 0);
    }

    private static boolean solve(Boolean[][] dp, String s, String p, int i, int j) {
        // Base case: If pattern is exhausted, string must also be exhausted for a match
        if (j == p.length()) return i == s.length();
        // Memoization check
        if (dp[i][j] != null) return dp[i][j];
        // Check if the current characters match
        boolean firstCharMatched = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If the next character in `p` is '*', handle zero or more occurrences of the previous element
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean skip = solve(dp, s, p, i, j + 2);  // Skip '*' and the preceding element
            boolean take = firstCharMatched && solve(dp, s, p, i + 1, j);  // Match '*' with current char in `s`
            dp[i][j] = skip || take;
        } else {
            // Move to the next character in both `s` and `p`
            dp[i][j] = firstCharMatched && solve(dp, s, p, i + 1, j + 1);
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
    }
}

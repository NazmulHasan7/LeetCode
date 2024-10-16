// 2370. Longest Ideal Subsequence
package Medium;
import java.util.Arrays;

public class Medium_2370_Longest_Ideal_Subsequence {
    public static int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n+1][26];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, s.toCharArray(), ' ', 0, n, k);
    }
    private static int solve(int[][] dp, char[] crr, char prev, int idx, int n, int k) {
        if (idx >= n) return 0;

        if (prev != ' ' && dp[idx][prev-'a'] != -1) return dp[idx][prev-'a'];

        int take = 0;
        if (prev == ' ' || Math.abs(crr[idx] - prev) <= k)
            take = 1 + solve(dp, crr, crr[idx], idx+1, n, k);

        int skip = solve(dp, crr, prev, idx+1, n, k);

        if (prev != ' ')
            return dp[idx][prev-'a'] = Math.max(take, skip);
        return Math.max(take, skip);
    }
    public int longestIdealStringTabulation(String s, int k) {
        int n = s.length();
        int[] dp = new int[26];
        // dp[i] -> Length of longest ideal string ending at character 'a' + i

        int result = 0;
        for (int i=0; i<n; i++) {
            int curr = s.charAt(i) - 'a';
            int leftRange = Math.max(0, curr - k);
            int rightRange = Math.min(25, curr + k);

            int longest = 0;
            for (int j=leftRange; j<=rightRange; j++) {
                longest = Math.max(longest, dp[j]);
            }
            dp[curr] = Math.max(dp[curr], 1 + longest);
            result = Math.max(result, dp[curr]);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString("abcd", 3));
    }
}

// 1048. Longest String Chain
package Medium;
import java.util.Arrays;

public class Medium_1048_Longest_String_Chain {
    // LIS -> Longest increasing subsequence approach
    // Recursion + Memoization
    public static int longestStrChain(String[] words) {
        // sort based on the word length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, words, -1, 0, n);
    }
    private static int solve(int[][] dp, String[] words, int prevIdx, int idx, int n) {
        if (idx >= n) return 0;
        if (prevIdx != -1 && dp[idx][prevIdx] != -1)
            return dp[idx][prevIdx];

        int take = 0;
        if (prevIdx == -1 || isPredecessor(words[prevIdx], words[idx]))
            take = 1 + solve(dp, words, idx, idx+1, n);

        int skip = solve(dp, words, prevIdx, idx+1, n);

        if (prevIdx != -1)
            dp[idx][prevIdx] = Math.max(take, skip);
        return Math.max(take, skip);
    }
    private static boolean isPredecessor(String word1, String word2) {
        int w1L = word1.length();
        int w2L = word2.length();
        if (w1L + 1 != w2L) return false;

        int i = 0, j = 0;
        while (i < w1L && j < w2L) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            } j++;
        } return i == w1L;
    }

    // Bottom-up Approach Or Tabulation Method
    public static int longestStrChainBottomUp(String[] words) {
        // sort based on the word length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        // dp[i] -> Longest chain ending at index i
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(longestStrChain(new String[]{"abcd","dbqca"}));
    }
}

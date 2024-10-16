// 139. Word Break
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Medium_139_Word_Break {
    // Recursion + Memoization -> TC O(n^2) SC O(n)
    private static HashSet<String> set;
    public static boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[] dp = new Boolean[n+1];
        return solve(dp, s, 0, n);
    }
    private static boolean solve(Boolean[] dp, String s, int idx, int n) {
        if (idx == n) return true;
        if (dp[idx] != null) return dp[idx];

        for (int endIdx = idx+1; endIdx<=n; endIdx++) {
            String sub = s.substring(idx, endIdx);
            // First check the first sub-string then the others
            if (set.contains(sub) && solve(dp, s, endIdx, n))
                return dp[idx] = true;
        }
        return dp[idx] = false;
    }
    // Tabulation Approach
    public static boolean wordBreakTabulation(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        // dp[i] -> Can this string be segmented at index i

        // Base case : an empty string can always be segmented
        dp[0] = true;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<i; j++) {
                if (set.contains(s.substring(j,i)) && dp[j])
                    dp[i] = true;
            }
        } return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet","code"))));
        System.out.println(wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple","pen"))));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"))));
    }
}

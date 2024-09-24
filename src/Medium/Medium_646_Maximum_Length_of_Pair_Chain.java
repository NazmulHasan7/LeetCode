// 646. Maximum Length of Pair Chain
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_646_Maximum_Length_of_Pair_Chain {
    // Recursion + Memoization Approach
    // TC -> O(n * log(n)) + O(n * n)
    // SC -> O (n * n)
    public static int findLongestChain(int[][] pairs) {
        // same LeetCode 300 as longest increasing subsequence
        int n = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, pairs, n, 0, -1);
    }
    private static int solve(int[][] dp, int[][] pairs, int n, int idx, int prevIdx) {
        if (idx >= n) return 0;
        if (prevIdx != -1 && dp[idx][prevIdx] != -1)
            return dp[idx][prevIdx];

        int take = 0;
        if (prevIdx == -1 || pairs[prevIdx][1] < pairs[idx][0])
            take = 1 + solve(dp, pairs, n, idx+1, idx);

        int skip = solve(dp, pairs, n, idx+1, prevIdx);
        if (prevIdx != -1)
            dp[idx][prevIdx] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    // Bottom-up Approach
    // TC -> O(n * log(n)) + O(n * n)
    // SC -> O (n)
    public static int findLongestChainBottomUp(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        // dp[i] => the longest chain up to ith index
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        } return maxLen;
    }

    // Greedy Solution
    // TC -> O(n * log(n)) + O(n)
    // SC -> O(1)
    public int findLongestChainGreedy(int[][] pairs) {
        int n = pairs.length;
        // sort based on 2nd element
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int prev = 0;
        int maxLen = 1;

        for (int i=1; i<n; i++) {
            if (pairs[prev][1] < pairs[i][0]) {
                prev = i;
                maxLen++;
            }
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(findLongestChain(new int[][]{{1,2},{7,8},{4,5}}));
    }
}

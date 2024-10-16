// 1218. Longest Arithmetic Subsequence of Given Difference
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_1218_Longest_Arithmetic_Subsequence_of_Given_Difference {
    public static int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, arr, 0, n, difference, -1);
    }
    private static int solve(int[][] dp, int[] arr, int idx, int n, int diff, int prev) {
        if (idx >= n) return 0;

        // prev indicates previous number's index not the previous number
        if (prev != -1 && dp[idx][prev] != -1)
            return dp[idx][prev];

        int skip = solve(dp, arr, idx+1, n, diff, prev);
        int take = 0;
        if (prev == -1 || arr[idx]-arr[prev] == diff)
            take = 1 + solve(dp, arr, idx+1, n, diff, idx);

        if (prev != -1)
            return dp[idx][prev] = Math.max(take, skip);

        return Math.max(take, skip);
    }
    public static int longestSubsequenceOptimized(int[] arr, int difference) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int result = 0;

        for (int curr : arr) {
            int validPrev = curr - difference;
            int value = map.getOrDefault(validPrev, 0);
            map.put(curr, value+1);
            result = Math.max(result, map.get(curr));
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestSubsequenceOptimized(new int[]{1,2,3,4},1));
        System.out.println(longestSubsequenceOptimized(new int[]{1,3,5,7},1));
        System.out.println(longestSubsequenceOptimized(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }
}

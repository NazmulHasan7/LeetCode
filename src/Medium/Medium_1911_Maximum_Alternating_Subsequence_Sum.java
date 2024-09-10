// 1911. Maximum Alternating Subsequence Sum
package Medium;
import java.util.Arrays;

public class Medium_1911_Maximum_Alternating_Subsequence_Sum {
    // Draw tree diagram -> Recursion + Memoization approach
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        /* Arrays.setAll(dp, row -> new long[]{-1, -1});
        // System.out.println(Arrays.deepToString(dp));
        // flag 0, even index -> +, flag 1, odd index -> -
        return solve(0, nums, dp, 0, n); */

        // Bottom up or Tabulation Approach
        for (int i=1; i<n+1; i++) {
            // For {2(+),3(-),4(+)} pick 5, then {2(+),3(-),4(+),5(-)}
            // After picking 5, it becomes an even length subsequence

            // Add at even index -> previous max odd sum - current element
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1], dp[i-1][0]);
            // Add at odd index -> previous max even sum + current element
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1], dp[i-1][1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
    private static long solve(int idx, int[] nums, long[][] dp, int flag, int n) {
        if (idx >= n) return 0;
        if (dp[idx][flag] != -1) return dp[idx][flag];

        // Option to skip the current element
        long skip = solve(idx+1, nums, dp, flag, n);
        // Option to take the current element
        int value = flag == 0 ? nums[idx] : -nums[idx];
        long take = value + solve(idx+1, nums, dp, 1 - flag, n);
        return dp[idx][flag] = Math.max(skip, take);
    }
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[]{4,2,5,3}));
        System.out.println(maxAlternatingSum(new int[]{5,6,7,8}));
        System.out.println(maxAlternatingSum(new int[]{6,2,1,2,4,5}));
    }
}

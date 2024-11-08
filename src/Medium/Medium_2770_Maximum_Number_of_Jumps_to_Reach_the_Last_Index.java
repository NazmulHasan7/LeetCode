// 2770. Maximum Number of Jumps to Reach the Last Index
package Medium;

import java.util.Arrays;

public class Medium_2770_Maximum_Number_of_Jumps_to_Reach_the_Last_Index {
    // Recursion + Memoization
    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int answer = solve(dp, nums, 0, n, target);
        return answer < 0 ? -1 : answer;
    }
    private static int solve(int[] dp, int[] nums, int idx, int n, int target) {
        if (idx == n-1) return 0;

        if (dp[idx] != -1) return dp[idx];

        int answer = Integer.MIN_VALUE;
        for (int j=idx+1; j<n; j++) {
            int diff = Math.abs(nums[j] - nums[idx]);
            if (diff <= target) {
                answer = Math.max(answer, 1 + solve(dp, nums, j, n, target));
            }
        } return dp[idx] = answer;
    }

    // Tabulation Approach
    public static int maximumJumpsTab(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n - 1] = 0;

        for (int idx = n - 2; idx >= 0; idx--) {
            for (int j = idx + 1; j < n; j++) {
                int diff = Math.abs(nums[j] - nums[idx]);
                if (diff <= target && dp[j] != Integer.MIN_VALUE) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[j]);
                }
            }
        } return dp[0] < 0 ? -1 : dp[0];
    }
    public static void main(String[] args) {
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2},2));
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2},3));
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2},0));
    }
}

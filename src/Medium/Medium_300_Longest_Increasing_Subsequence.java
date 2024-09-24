// 300. Longest Increasing Subsequence
package Medium;
import java.util.Arrays;

public class Medium_300_Longest_Increasing_Subsequence {
    // Longest Increasing Subsequence -> both TC O(n^2)
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 2 variables changing -> index, previous
        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, nums,0, n,-1);
    }
    private static int solve(int[][] dp, int[] nums, int idx, int n, int previousIdx) {
        if (idx >= n) return 0;
        if (previousIdx != -1 && dp[idx][previousIdx] != -1)
            return dp[idx][previousIdx];

        int take = 0;
        if (previousIdx == -1 || nums[idx] > nums[previousIdx])
            take = 1 + solve(dp, nums, idx+1, n, idx);

        int skip = solve(dp, nums, idx+1, n, previousIdx);
        if (previousIdx != -1)
            dp[idx][previousIdx] = Math.max(take, skip);

        return Math.max(take, skip);
    }
    public static int lengthOfLISBottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] -> Longest increasing subsequence ending at ith index
        Arrays.fill(dp, 1); // element itself

        int maxLIS = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    // a possible increasing sequence
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    // add the current element to the LIS ending at index j
                    maxLIS = Math.max(dp[i], maxLIS);
                }
            }
        } return maxLIS;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}

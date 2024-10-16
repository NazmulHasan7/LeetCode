// 376. Wiggle Subsequence
package Medium;
import java.util.Arrays;

public class Medium_376_Wiggle_Subsequence {
    // Recursion + Memoization -> TC and SC -> O(n^2)
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[][][] dp = new int[n+1][n+1][2];
        for (int[][] dr : dp)
            for (int[] dc : dr)
                Arrays.fill(dc, -1);
        return Math.max(solve(dp, nums, 0, n, 0, -1), solve(dp, nums, 0, n, 1, -1));
    }
    private static int solve(int[][][] dp, int[] nums, int idx, int n, int sign, int prevIdx) {
        if (idx >= n) return 0;
        // have two options, take or skip

        if (prevIdx != -1 && dp[idx][prevIdx][sign] != -1)
            return dp[idx][prevIdx][sign];

        int take = 0;
        if (prevIdx == -1) {
            take = 1 + solve(dp, nums, idx + 1, n, 1 - sign, idx);
        } else {
            int diff = nums[idx] - nums[prevIdx];
            if (sign == 0 && diff > 0 || sign == 1 && diff < 0)
                take = 1 + solve(dp, nums, idx+1, n, 1-sign, idx);
        }
        int skip = solve(dp, nums, idx+1, n, sign, prevIdx);

        if (prevIdx != -1)
            return dp[idx][prevIdx][sign] = Math.max(take, skip);
        return Math.max(take, skip);
    }

    // Optimized code
    public int wiggleMaxLengthOptimized(int[] arr) {
        int n = arr.length;
        if (n < 2) return n;

        // When we have at least one element, there is a wiggle sequence
        int count = 1;
        int prevDiff = arr[1] - arr[0];
        // If the first two elements form a wiggle, count becomes 2
        if (prevDiff != 0) count = 2;

        for (int i=2; i<n; i++) {
            int currDiff = arr[i] - arr[i-1];
            // If the current difference has a different sign compared to the prevDiff
            if (prevDiff >= 0 && currDiff < 0 || prevDiff <= 0 && currDiff > 0) {
                count++;
                prevDiff = currDiff;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}

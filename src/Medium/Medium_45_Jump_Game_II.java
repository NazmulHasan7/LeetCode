// 45. Jump Game II
package Medium;
import java.util.Arrays;

public class Medium_45_Jump_Game_II {
    // Recursion + Memoization --> TC O(n^2) SC O(n)
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(dp, nums, 0, n);
    }
    private static int solve(int[] dp, int[] nums, int idx, int n) {
        // Base case : already reached the last index, so need zero jump
        if (idx >= n-1) return 0;
        if (dp[idx] != -1) return dp[idx];

        int minJumps = 10007; // to avoid the overflow
        for (int i=1; i<=nums[idx]; i++) {
            int jumps = 1 + solve(dp, nums, idx+i, n);
            minJumps = Math.min(minJumps, jumps);
        }
        return dp[idx] = minJumps;
    }

    // Tabulation -> TC O(n^2) SC O(n)
    public static int jumpTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        Arrays.fill(dp, 10007);
        // dp[i] -> minimum jumps required to reach index i
        dp[0] = 0;

        for (int idx=0; idx<n; idx++) {
            for (int k=1; k<=nums[idx] && idx+k < n; k++)
                dp[idx+k] = Math.min(dp[idx+k], dp[idx] + 1);
        }
        return dp[n-1];
    }

    // Greedy Approach
    public static int jumpGreedy(int[] nums) {
        int destination = nums.length - 1;
        int jumps = 0;

        int start = 0, end = 0;
        while (end < destination) {
            int farthest = 0;
            for (int k=start; k<=end; k++)
                farthest = Math.max(farthest, k + nums[k]);

            start = end + 1;
            end = farthest;
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
}

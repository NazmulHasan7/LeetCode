// 55. Jump Game
package Medium;

public class Medium_55_Jump_Game {
    // Recursion + Memoization approach
    // TC -> O(n^2) SC -> O(n)
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return solve(dp, nums, 0, n);
    }
    private static boolean solve(Boolean[] dp, int[] nums, int idx, int n) {
        if (idx >= n) return false; // out of bound
        if (idx == n-1) return true; // reached the last index
        if(dp[idx] != null) return dp[idx];

        for (int i=1; i<=nums[idx]; i++) // try each step for a jump
            if (solve(dp, nums, idx+i, n))
                return dp[idx] = true;

        return dp[idx] = false;
    }
    // Bottom up or Tabulation approach
    // TC -> O(n^2) SC -> O(n)
    public static boolean canJumpBottomUp(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        // dp[i] == true -> can reach index i
        dp[0] = true;

        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        } return dp[n-1];
    }
    // Better approach -> TC -> O(n) SC -> O(1)
    public static boolean canJumpBetter(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;

        for (int i=0; i<n; i++) {
            if (i > maxReachable)
                return false;
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}

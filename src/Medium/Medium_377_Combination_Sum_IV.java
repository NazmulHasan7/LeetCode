// 377. Combination Sum IV
package Medium;
import java.util.Arrays;

public class Medium_377_Combination_Sum_IV {
    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, nums, target, 0, n);
    }
    private static int solve(int[][] dp, int[] nums, int target, int idx, int n) {
        if (idx >= n || target < 0) return 0; // Invalid case
        if (target == 0) return 1; // One combination found
        if (dp[idx][target] != -1) return dp[idx][target]; // Already calculated

        // If we take a number, we need to check all the combinations
        int take = solve(dp, nums, target-nums[idx], 0, n);
        int skip = solve(dp, nums, target, idx+1, n);
        return dp[idx][target] = take + skip;
    }
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
        System.out.println(combinationSum4(new int[]{9},3));
    }
    // Space Optimization
    public int combinationSum4Better(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1); // Initialize dp array with -1
        return solveBetter(dp, nums, target, 0, n);
    }
    private int solveBetter(int[] dp, int[] nums, int target, int idx, int n) {
        if (idx >= n || target < 0) return 0; // Invalid case
        if (target == 0) return 1;
        if (dp[target] != -1) return dp[target]; // Return already computed result

        int take = solveBetter(dp, nums, target-nums[idx], 0, n);
        int skip = solveBetter(dp, nums, target, idx+1, n);
        return dp[target] = take + skip;
    }
}

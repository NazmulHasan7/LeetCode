// 416. Partition Equal Subset Sum
package Medium;

public class Medium_416_Partition_Equal_Subset_Sum {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;

        // For odd sum -> Cannot be partitioned into equal sum subsets
        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[n+1][target+1];
        return solve(dp, nums, target, 0, n);
    }
    private static boolean solve(Boolean[][] dp, int[] nums, int target, int idx, int n) {
        if (idx >= n || target < 0) return false;
        if (target == 0) return true;
        if (dp[idx][target] != null) return dp[idx][target];

        // take is subset 1 or skip [take it in subset 2]
        boolean skip = solve(dp, nums, target, idx+1, n);
        boolean take = false;
        if (nums[idx] <= target)
            take = solve(dp, nums, target-nums[idx], idx+1, n);
        return dp[idx][target] = take || skip;
    }
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }
}

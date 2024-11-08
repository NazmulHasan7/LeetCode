// 494. Target Sum
package Medium;

import java.util.HashMap;

public class Medium_494_Target_Sum {
    // Backtracking
    public static int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target, 0);
    }
    private static int backtrack(int[] nums, int idx, int target, int currSum) {
        if (idx == nums.length) {
            if (target == currSum)
                return 1;
            return 0;
        }
        return backtrack(nums, idx + 1, target, currSum + nums[idx]) +
                backtrack(nums, idx + 1, target, currSum - nums[idx]);
    }
    // Recursion + Memoization
    public static int findTargetSumWaysMemo(int[] nums, int target) {
        return solve(nums, 0, nums.length, 0, target, new HashMap<String, Integer>());
    }
    private static int solve(int[] nums, int idx, int n, int sum, int target, HashMap<String, Integer> dp) {
        if (idx == n)
            return sum == target ? 1 : 0;

        String key = idx + "_" + sum;
        if (dp.containsKey(key)) return dp.get(key);

        int ways = 0;
        ways += solve(nums, idx+1, n, sum + nums[idx], target, dp);
        ways += solve(nums, idx+1, n, sum - nums[idx], target, dp);

        dp.put(key, ways);
        return ways;
    }
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
    }
}

// 2369. Check if There is a Valid Partition For The Array
package Medium;

public class Medium_2369_Check_if_There_is_a_Valid_Partition_For_The_Array {
    // Recursion + Memoization
    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n+1];
        return solve(dp, nums, 0, n);
    }
    private static boolean solve(Boolean[] dp, int[] nums, int idx, int n) {
        if (idx >= n) return true;

        if (dp[idx] != null) return dp[idx];

        boolean result = false;
        if (idx + 1 < n && nums[idx] == nums[idx+1]) { // Rule 1 -> 2 exactly equal elements
            result = solve(dp, nums, idx+2, n);
            if (result) return dp[idx] = true;
        }
        if (idx + 2 < n && nums[idx] == nums[idx+1] && nums[idx+1] == nums[idx+2]) {
            // Rule 2 -> 3 exactly equal elements
            result = solve(dp, nums, idx+3, n);
            if (result) return dp[idx] = true;
        }
        if (idx + 2 < n && nums[idx] + 1 == nums[idx+1] && nums[idx+1] + 1 == nums[idx+2]) {
            // Rule 3 -> 3 consecutive increasing elements
            result = solve(dp, nums, idx+3, n);
            if (result) return dp[idx] = true;
        }
        return dp[idx] = false;
    }
    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{4,4,4,5,6}));
        System.out.println(validPartition(new int[]{1,1,1,2}));
    }
}

// 213. House Robber II
package Medium;
import java.util.Arrays;

public class Medium_213_House_Robber_II {
    private static int solve(int[] nums, int[] dp, int n, int idx) {
        if (idx > n) return 0;
        if (dp[idx] != -1) return dp[idx];
        int skip = solve(nums, dp, n, idx+1);
        int robHouse = nums[idx] + solve(nums, dp, n, idx+2);
        return dp[idx] = Math.max(skip, robHouse);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);
        // Since the array is a circular array, there are 2 cases
        // Case 01 -> rob first house, then cannot rob the last house
        int robFirstHouse = solve(nums, dp, n-2, 0);

        Arrays.fill(dp, -1);
        // Case 02 -> rob second house, then can rob the last house
        int robSecondHouse = solve(nums, dp, n-1, 1);

        return Math.max(robFirstHouse, robSecondHouse);
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1,2,3}));
    }
}

// 198. House Robber
package Medium;
import java.util.Arrays;

public class Medium_198_House_Robber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return robHelper(nums, dp, 0);
    }
    private static int robHelper(int[] nums, int[] dp, int index) {
        // House index out of range
        if (index >= nums.length) return 0;
        if (dp[index] != -1)
            return dp[index];
        int skipHouse = robHelper(nums, dp, index+1);
        // As consecutive houses cannot be robbed
        int robHouse = nums[index] + robHelper(nums, dp, index+2);
        return dp[index] = Math.max(skipHouse, robHouse);
    }
    public static int robBottomUp(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];

        dp[0] = 0; // no house, i = 0
        dp[1] = nums[0]; // 1 house, i = 0
        for (int i=2; i<=nums.length; i++) {
            int skip = dp[i-1];
            int robHouse = nums[i-1] + dp[i-2];
            dp[i] = Math.max(skip, robHouse);
        }
        return dp[nums.length];
    }

    // Constant space
    public static int robBetter(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prev2 = 0; // no house robbed -> starting at house 0
        int prev1 = nums[0]; // house 1 robbed

        for (int i=2; i<=n; i++) {
            int skip = prev1; // do not rob the current house
            int robIt = nums[i-1] + prev2; // rob the current house

            int tempMax = Math.max(skip, robIt);
            prev2 = prev1;
            prev1 = tempMax;
        }
        return prev1;
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(robBottomUp(new int[]{1,2,3,1}));
        System.out.println(robBottomUp(new int[]{2,7,9,3,1}));
    }
}

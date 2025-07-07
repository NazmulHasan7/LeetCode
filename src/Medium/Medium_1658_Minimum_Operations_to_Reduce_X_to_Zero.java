// 1658. Minimum Operations to Reduce X to Zero
package Medium;
import java.util.Arrays;

public class Medium_1658_Minimum_Operations_to_Reduce_X_to_Zero {
    // DP solution - MLE
    static int[][] dp;
    public static int minOperationsDP(int[] nums, int x) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int answer = solve(nums, 0, n-1, x, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private static int solve(int[] nums, int st, int en, int x, int ops) {
        if (x == 0) return ops;
        if (st > en) return Integer.MAX_VALUE;

        if (dp[st][en] != -1) return dp[st][en];

        int removeLeft = solve(nums, st+1, en, x-nums[st], ops+1);
        int removeRight = solve(nums, st, en-1, x-nums[en], ops+1);
        return dp[st][en] = Math.min(removeLeft, removeRight);
    }
    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        int target = sum - x;
        // Think in reverse -> find the max len of sum matching the target
        int currSum = 0;
        int maxLen = -1;

        for (int l=0, r=0; r<n; r++) {
            currSum += nums[r];
            while (l <= r && currSum > target)
                currSum -= nums[l++];
            if (currSum == target)
                maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println(minOperations(new int[]{5,6,7,8,9}, 4));
        System.out.println(minOperations(new int[]{3,2,20,1,1,3}, 10));
    }
}

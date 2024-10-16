// 740. Delete and Earn
package Medium;
import java.util.Arrays;

public class Medium_740_Delete_and_Earn {
    // Recursion + Memoization
    public static int deleteAndEarn(int[] nums) {
        // Converting the problem to House Robber problem
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        int[] freq = new int[max+1];
        for (int num : nums) freq[num] += num;

        int[] dp = new int[max+1];
        Arrays.fill(dp,-1);
        return solve(dp, freq, 0, freq.length);
    }
    private static int solve(int[] dp, int[] freq, int idx, int n) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];

        int take = freq[idx] + solve(dp, freq, idx+2, n);
        int skip = solve(dp, freq, idx+1, n);
        return dp[idx] = Math.max(take, skip);
    }
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}

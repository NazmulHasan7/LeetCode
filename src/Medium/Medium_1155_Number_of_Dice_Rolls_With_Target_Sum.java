// 1155. Number of Dice Rolls With Target Sum
package Medium;
import java.util.Arrays;

public class Medium_1155_Number_of_Dice_Rolls_With_Target_Sum {
    private static final int MOD = (int) 1E9 + 7;
    public static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(dp, n, k, target) % MOD;
    }
    private static int solve(int[][] dp, int n, int k, int target) {
        if (n == 0 && target == 0) return 1;
        if (n < 0) return 0;
        if (target < 0) return 0;

        if (dp[n][target] != -1) return dp[n][target];

        int ways = 0;
        for (int i=1; i<=k; i++)
            ways = (ways + solve(dp, n-1, k, target-i)) % MOD;

        return dp[n][target] = ways;
    }
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));
        System.out.println(numRollsToTarget(2,6,7));
        System.out.println(numRollsToTarget(30,30,500));
    }
}

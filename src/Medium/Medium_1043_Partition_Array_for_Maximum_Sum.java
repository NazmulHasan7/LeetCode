// 1043. Partition Array for Maximum Sum
package Medium;
import java.util.Arrays;

public class Medium_1043_Partition_Array_for_Maximum_Sum {
    // Time complexity without memoization -> O(k^n)
    // Time complexity with memoization -> O(n*k), SC O(n)
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, arr, 0, n, k);
    }
    private static int solve(int[] dp, int[] arr, int idx, int n, int k) {
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int result = 0;
        int currentMax = 0;
        for (int i=idx; i<idx+k && i<n; i++) {
            currentMax = Math.max(currentMax, arr[i]);
            result = Math.max(result, (currentMax * (i-idx+1) + solve(dp, arr, i+1, n, k)));
        }
        return dp[idx] = result;
    }
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
        System.out.println(maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3},4));
    }
}

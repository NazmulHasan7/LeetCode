// 801. Minimum Swaps To Make Sequences Increasing
package Hard;
import java.util.Arrays;

public class Hard_801_Minimum_Swaps_To_Make_Sequences_Increasing {
    // Pattern -> 0/1 knapsack problem
    // Recursion + Memoization
    public static int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[][] dp = new int[n+1][2];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(dp, nums1, nums2, 0, n, 0, -1, -1);
    }
    private static int solve(int[][] dp, int[] nums1, int[] nums2, int idx, int n, int isSwapped, int prev1, int prev2) {
        // Using the classical 0/1 knapsack route -> We have two options, swap it or skip it
        if (idx == n) return 0; // out of bound

        if (dp[idx][isSwapped] != -1) return dp[idx][isSwapped];

        // Option 01 -> Do not swap
        int skip = Integer.MAX_VALUE;
        if (nums1[idx] > prev1 && nums2[idx] > prev2) {
            // both arrays are in strongly increasing sequence
            skip = solve(dp, nums1, nums2, idx+1, n, 0, nums1[idx], nums2[idx]);
        }
        // Option 02 -> Swap
        // Perform the swap
        int temp = nums1[idx];
        nums1[idx] = nums2[idx];
        nums2[idx] = temp;

        int swap = Integer.MAX_VALUE;
        if (nums1[idx] > prev1 && nums2[idx] > prev2) {
            // after the swap both arrays are in strongly increasing sequence
            swap = 1 + solve(dp, nums1, nums2, idx+1, n, 1, nums1[idx], nums2[idx]);
        }
        // Now undo the swap
        temp = nums1[idx];
        nums1[idx] = nums2[idx];
        nums2[idx] = temp;

        return dp[idx][isSwapped] = Math.min(skip, swap);
    }
    public static void main(String[] args) {
        System.out.println(minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
        System.out.println(minSwap(new int[]{0,3,5,8,9}, new int[]{2,1,4,6,9}));
    }
}

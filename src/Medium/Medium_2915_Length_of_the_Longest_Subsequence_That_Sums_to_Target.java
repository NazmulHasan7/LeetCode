// 2915. Length of the Longest Subsequence That Sums to Target
package Medium;
import java.util.Arrays;
import java.util.List;

public class Medium_2915_Length_of_the_Longest_Subsequence_That_Sums_to_Target {
    // Time and space complexity - O(n * target)
    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n+1][target+1];
        for (int[] d : dp) Arrays.fill(d, Integer.MIN_VALUE);
        int answer = solve(dp, nums, target, 0, n);
        return answer < 0 ? -1 : answer;
    }
    private static int solve(int[][] dp, List<Integer> nums, int target, int idx, int n) {
        if (idx >= n) return Integer.MIN_VALUE;  // target cannot be reached
        if (target < 0) return Integer.MIN_VALUE; // target cannot be reached
        if (target == 0) return 0; // target reached

        if (dp[idx][target] != Integer.MIN_VALUE) return dp[idx][target];

        int take = 1 + solve(dp, nums, target - nums.get(idx), idx+1, n);
        int skip = solve(dp, nums, target, idx+1, n);
        return dp[idx][target] = Math.max(take, skip);
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubsequence(List.of(1,2,3,4,5),9));
        System.out.println(lengthOfLongestSubsequence(List.of(4,1,3,2,1,5),7));
        System.out.println(lengthOfLongestSubsequence(List.of(1,1,5,4,5),3));
    }
}

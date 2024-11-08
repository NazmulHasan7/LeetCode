// 1027. Longest Arithmetic Subsequence
package Medium;
import java.util.HashMap;

public class Medium_1027_Longest_Arithmetic_Subsequence {
    // Recursion + Memoization -> TLE
    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n, -1, -5000, new HashMap<>());
    }
    private static int solve(int[] nums, int idx, int n, int prevIdx, int diff, HashMap<String, Integer> dp) {
        if (idx >= n) return 0;

        String key = idx + "_" + prevIdx + "_" + diff;
        if (dp.containsKey(key))
            return dp.get(key);

        int take = 0;
        int skip = 0;
        if (prevIdx == -1) {
            take = 1 + solve(nums, idx+1, n, idx, diff, dp);
            skip = solve(nums, idx+1, n, prevIdx, diff, dp);
        }
        else {
            int newDiff = nums[idx] - nums[prevIdx];

            if (diff == -5000) {
                take = 1 + solve(nums, idx+1, n, idx, newDiff, dp);
                skip = solve(nums, idx+1, n, prevIdx, diff, dp);
            } else if (newDiff == diff) {
                take = 1 + solve(nums, idx+1, n, idx, diff, dp);
            } else {
                skip = solve(nums, idx+1, n, prevIdx, diff, dp);
            }
        }
        int answer = Math.max(take, skip);
        dp.put(key, answer);
        return answer;
    }

    // LIS Approach -> Longest Increasing Subsequence
    public static int longestArithSeqLengthOptimized(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][1001]; // 1001 is the maximum difference
        // dp[i][diff] -> the longest arithmetic subsequence end at index i with same difference diff

        int answer = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                int diff = nums[i] - nums[j] + 500; // to avoid the -ve diff

                dp[i][diff] = dp[j][diff] > 0 ? dp[j][diff] + 1 : 2;
                answer = Math.max(answer, dp[i][diff]);
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(longestArithSeqLength(new int[]{3,6,9,12}));
        System.out.println(longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
}

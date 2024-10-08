// 368. Largest Divisible Subset
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_368_Largest_Divisible_Subset {
    // Backtracking approach - TLE -> TC(2^n)
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, nums.length, -1, temp, answer);
        return answer;
    }
    private static void backtrack(int[] nums, int idx, int n, int prev, List<Integer> temp, List<Integer> answer) {
        if (idx >= n) {
            if (temp.size() > answer.size()) {
                answer.clear();
                answer.addAll(temp);
            } return;
        }
        // Take
        if (prev == -1 || nums[idx] % prev == 0) {
            temp.add(nums[idx]);
            backtrack(nums, idx+1, n, nums[idx], temp, answer);
            temp.removeLast(); // Undo the take
        }
        // Skip
        backtrack(nums, idx+1, n, prev, temp, answer);
    }
    // Tabulation -> TC -> O(n^2)
    public static List<Integer> largestDivisibleSubsetBottomUp(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // dp[i] -> Longest increasing subsequence ending at index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int maxLen = 0;
        int lastChosenIndex = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j; // from which index it came

                        if (dp[i] > maxLen) {
                            maxLen = dp[i];
                            lastChosenIndex = i;
                        }
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (lastChosenIndex != - 1) {
            answer.add(nums[lastChosenIndex]);
            lastChosenIndex = parent[lastChosenIndex];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}

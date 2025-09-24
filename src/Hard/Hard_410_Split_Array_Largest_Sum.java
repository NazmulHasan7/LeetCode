// 410. Split Array Largest Sum
package Hard;
import java.util.*;

public class Hard_410_Split_Array_Largest_Sum {
    public static int splitArray1(int[] nums, int k) {
        int n = nums.length;

        int[] rightSum = new int[n];
        rightSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightSum[i] = rightSum[i + 1] + nums[i];

        Map<String, Integer> memo = new HashMap<>();
        return solve(nums, 0, 0, k, n, rightSum, memo);
    }
    private static int solve(int[] nums, int idx, int subArraySum, int k, int n,
                             int[] rightSum, Map<String, Integer> memo) {
        if (idx == n) return subArraySum;

        // invalid split, reach the end but k is not 1
        if (idx == n-1 && k > 1) return Integer.MAX_VALUE / 2;
        if (k == 1) return subArraySum + rightSum[idx]; // rest of the array as a partition

        String key = idx + "," + k + "," + subArraySum;
        if (memo.containsKey(key)) return memo.get(key);

        subArraySum += nums[idx];

        // Case 1 : skip or extend the current sub-array
        int skip = solve(nums, idx+1, subArraySum, k, n, rightSum, memo);
        // Case 2 : split at current index, end current sub-array and start a new from next index
        int split = Math.max(subArraySum, solve(nums, idx+1, 0, k-1, n, rightSum, memo));

        int answer = Math.min(skip, split);
        memo.put(key, answer);
        return answer;
    }

    public static int splitArray2(int[] nums, int k) {
        int[][] dp = new int[nums.length+1][k+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(nums, 0, k, dp);
    }
    private static int solve(int[] nums, int start, int k, int[][] dp) {
        int n = nums.length;
        if (start == n) {
            if (k == 0) return 0;
            return Integer.MAX_VALUE; // invalid split
        }
        if (k == 0) // invalid split
            return Integer.MAX_VALUE;

        if (dp[start][k] != -1) return dp[start][k];

        int answer = Integer.MAX_VALUE;
        int subArraySum = 0;
        // for each starting of a sub-array try all possible split points
        for (int i=start; i<n; i++) {
            subArraySum += nums[i];
            int rightSum = solve(nums, i+1, k-1, dp);
            int largestSum = Math.max(subArraySum, rightSum);
            answer = Math.min(answer, largestSum);
        }
        return dp[start][k] = answer;
    }

    private static boolean canSplit(int[] nums, int target, int k) {
        long sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                // start a new sub-array from current index
                sum = num;
                count++;
                if (count > k) return false; // no split left
            }
        } return true;
    }

    public static int splitArray(int[] nums, int k) {
        int sum = 0; // maximum that the sub-array sum can be
        long maxElement = Integer.MIN_VALUE; // minimum that the sub-array sum can be

        for (int num : nums) {
            sum += num;
            maxElement = Math.max(maxElement, num);
        }

        long left = maxElement;
        long right = sum;
        int answer = -1;

        while (left <= right) {
            // possible sub-array sum
            int subArraySum = (int) (left + (right - left) / 2);
            if (canSplit(nums, subArraySum, k)) {
                answer = subArraySum;
                // check in the left range for smaller sum
                right = subArraySum - 1;
            } else {
                left = subArraySum + 1;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
        System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
    }
}

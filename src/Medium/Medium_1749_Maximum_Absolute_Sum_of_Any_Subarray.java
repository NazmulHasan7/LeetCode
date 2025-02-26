// 1749. Maximum Absolute Sum of Any Subarray
package Medium;

public class Medium_1749_Maximum_Absolute_Sum_of_Any_Subarray {
    // Using Kadane's Algorithm
    public static int maxAbsoluteSum(int[] nums) {
        // Find the maximum sub-array sum using Kadane's algorithm
        int sum = 0, maxSubArraySum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSubArraySum = Math.max(maxSubArraySum, sum);
            if (sum < 0) sum = 0;
        }

        // Find the minimum sub-array sum using the reverse Kadane's algorithm
        sum = 0;
        int minSubArraySum = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            minSubArraySum = Math.min(minSubArraySum, sum);
            if (sum > 0) sum = 0;
        }
        return Math.max(maxSubArraySum, Math.abs(minSubArraySum));
    }
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        System.out.println(maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }
}

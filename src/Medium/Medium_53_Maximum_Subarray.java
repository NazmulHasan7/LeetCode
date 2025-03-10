// 53. Maximum Sub-array
package Medium;

public class Medium_53_Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            answer = Math.max(sum, answer);
            // Since we are looking for the maximum sum sub-array
            // If the sum is negative, reset the sum as adding more negative makes the number even smaller
            if (sum < 0) sum = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}

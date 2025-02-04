// 1800. Maximum Ascending Subarray Sum
package Easy;

public class Easy_1800_Maximum_Ascending_Subarray_Sum {
    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        int sum = nums[0];

        for (int i=1; i<n; i++) {
            if (nums[i-1] < nums[i]) {
                sum += nums[i];
            } else {
                maxSum = Math.max(maxSum, sum);
                sum = nums[i];
            }
        } return Math.max(maxSum, sum);
    }
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
    }
}

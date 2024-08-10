// 643. Maximum Average Subarray I
package Easy;

public class Easy_643_Maximum_Average_Subarray_I {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum;
        for (int i=0; i<k; i++)
            sum += nums[i];
        maxSum = sum;

        int left = 1, right = k;
        while (right < nums.length) {
            sum += nums[right] - nums[left-1];
            maxSum = Math.max(sum, maxSum);
            left++;
            right++;
        } return (double)maxSum / k;
    }
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
    }
}

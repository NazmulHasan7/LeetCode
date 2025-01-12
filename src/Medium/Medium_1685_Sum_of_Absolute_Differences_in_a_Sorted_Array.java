// 1685. Sum of Absolute Differences in a Sorted Array
package Medium;
import java.util.Arrays;

public class Medium_1685_Sum_of_Absolute_Differences_in_a_Sorted_Array {
    /*
    1. total sum
    2. left sum -> maintain a prefix array
    3. right sum -> total sum - left sum - num[i]
    right sum - (count of right num * num[i]) n - left - 1 [ignore current num also]
       + count of left * num[i] - left sum
    */
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i=1; i<n; i++)
            prefix[i] = prefix[i-1] + nums[i];

        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[n-1] - prefix[i];
            // int leftCount = i;
            int rightCount = n-i-1;

            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            answer[i] = leftTotal + rightTotal;
        }
        return answer;
    }
    public static int[] getSumAbsoluteDifferencesSpaceOpt(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        int leftSum = 0;
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int rightSum = totalSum - nums[i] - leftSum;
            int rightCount = n-1-i;
            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];

            answer[i] = leftTotal + rightTotal;
            leftSum += nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2,3,5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{1,4,6,8,10})));
    }
}

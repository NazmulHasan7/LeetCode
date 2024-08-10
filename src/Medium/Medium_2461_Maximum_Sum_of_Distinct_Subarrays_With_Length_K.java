// 2461. Maximum Sum of Distinct Sub-arrays With Length K
package Medium;
import java.util.HashSet;

public class Medium_2461_Maximum_Sum_of_Distinct_Subarrays_With_Length_K {
    public static long maximumSubarraySum(int[] nums, int k) {
        int left = 0, right = 0;
        long windowSum = 0, maxSum = 0;
        HashSet<Integer> set = new HashSet<>();

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                windowSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            windowSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            } right++;
        } return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
        System.out.println(maximumSubarraySum(new int[]{4,4,4}, 3));
    }
}

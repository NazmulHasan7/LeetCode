// 930. Binary Sub-arrays With Sum
package Medium;

public class Medium_930_Binary_Subarrays_With_Sum {
    // The function returns the difference between goal and goal-1
    // Effectively finding the number of sub-arrays with sum exactly equal to goal
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return subArraysWithSum(nums, goal) - subArraysWithSum(nums, goal-1);
    }
    public static int subArraysWithSum(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, right = 0;
        int answer = 0, sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            answer += (right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}

// 2044. Count Number of Maximum Bitwise-OR Subsets
package Medium;

public class Medium_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets {
    static int maxSum = 0, count = 0;
    public static int countMaxOrSubsets(int[] nums) {
        backtrack(nums,0,0);
        return count;
    }
    private static void backtrack(int[] nums, int idx, int currentSum) {
        if (idx == nums.length) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
                count = 1;
            } else if (currentSum == maxSum){
                count++;
            } return;
        }
        // Choose to add the current value
        backtrack(nums, idx+1, currentSum | nums[idx]);
        // Choose NOT to add the current value
        backtrack(nums, idx+1, currentSum);
    }
    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3,1}));
        System.out.println(countMaxOrSubsets(new int[]{2,2,2}));
        System.out.println(countMaxOrSubsets(new int[]{3,2,1,5}));
    }
}

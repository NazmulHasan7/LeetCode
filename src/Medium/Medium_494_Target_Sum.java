// 494. Target Sum
package Medium;

public class Medium_494_Target_Sum {
    public static int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target, 0);
    }
    private static int backtrack(int[] nums, int idx, int target, int currSum) {
        if (idx == nums.length) {
            if (target == currSum)
                return 1;
            return 0;
        }
        return backtrack(nums, idx + 1, target, currSum + nums[idx]) +
                backtrack(nums, idx + 1, target, currSum - nums[idx]);
    }
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
    }
}

// 1863. Sum of All Subset XOR Totals
package Easy;

public class Easy_1863_Sum_of_All_Subset_XOR_Totals {
    public static int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }
    private static int backtrack(int[] nums, int index, int currrentSum) {
        if (index == nums.length) return currrentSum;
        // Choose to include the current element
        int include = backtrack(nums, index+1, nums[index] ^ currrentSum);
        // Choose NOT to include the current element
        int exclude = backtrack(nums, index+1, currrentSum);
        return include + exclude;
    }
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3}));
        System.out.println(subsetXORSum(new int[]{5,1,6}));
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
}

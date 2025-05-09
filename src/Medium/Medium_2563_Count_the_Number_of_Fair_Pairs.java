// 2563. Count the Number of Fair Pairs
package Medium;
import java.util.Arrays;

public class Medium_2563_Count_the_Number_of_Fair_Pairs {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return pairsWithSumLessThan(nums, upper+1) -
                pairsWithSumLessThan(nums, lower);
    }
    private static long pairsWithSumLessThan(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        long count = 0;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                count += (end - start);
                start++;
            } else {
                end--;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0,1,7,4,4,5},3,6));
        System.out.println(countFairPairs(new int[]{1,7,9,2,5},11,11));
    }
}

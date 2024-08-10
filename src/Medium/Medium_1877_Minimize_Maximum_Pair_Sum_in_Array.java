// 1877. Minimize Maximum Pair Sum in Array
package Medium;
import java.util.Arrays;

public class Medium_1877_Minimize_Maximum_Pair_Sum_in_Array {
    // Pair them in such a way that when all pairs are summed individually,
    // then the max of those sum's is taken it should be as minimum as possible
    public static int minPairSum(int[] nums) {
        int maxSum = 0;
        Arrays.sort(nums);
        for (int i=0, j=nums.length-1; i<j; i++,j--)
            maxSum = Math.max(nums[i] + nums[j], maxSum);
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[] {3,5,2,3}));
        System.out.println(minPairSum(new int[] {3,5,4,2,4,6}));
    }
}

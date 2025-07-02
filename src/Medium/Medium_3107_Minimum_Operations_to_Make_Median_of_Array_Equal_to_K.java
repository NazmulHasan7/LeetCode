// 3107. Minimum Operations to Make Median of Array Equal to K
package Medium;
import java.util.Arrays;

public class Medium_3107_Minimum_Operations_to_Make_Median_of_Array_Equal_to_K {
    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int m = nums.length / 2;
        long ops = Math.abs(nums[m]-k);

        for (int i=0; i<m; i++)
            if (nums[i] > k) ops += nums[i]-k;

        for (int i=m+1; i<nums.length; i++)
            if (nums[i] < k) ops += k-nums[i];
        return ops;
    }
    public static void main(String[] args) {
        System.out.println(minOperationsToMakeMedianK(new int[]{2,5,6,8,5},4));
        System.out.println(minOperationsToMakeMedianK(new int[]{2,5,6,8,5},7));
        System.out.println(minOperationsToMakeMedianK(new int[]{1,2,3,4,5,6},4));
    }
}

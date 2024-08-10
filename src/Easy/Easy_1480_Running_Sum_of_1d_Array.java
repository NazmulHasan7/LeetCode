// 1480. Running Sum of 1d Array
package Easy;
import java.util.Arrays;

public class Easy_1480_Running_Sum_of_1d_Array {
    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1; i<nums.length; i++)
            sum[i] = sum[i-1] + nums[i];
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(runningSum(new int[] {1,1,1,1,1})));
    }
}

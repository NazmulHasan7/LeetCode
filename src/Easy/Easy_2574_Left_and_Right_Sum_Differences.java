// 2574. Left and Right Sum Differences
package Easy;
import java.util.Arrays;

public class Easy_2574_Left_and_Right_Sum_Differences {
    public static int[] leftRightDifference(int[] nums) {
        int[] diff = new int[nums.length];
        int sum = 0;
        // Left summation
        for (int i=0; i<nums.length; i++) {
            diff[i] = sum;
            sum += nums[i];
        }
        for (int i=0; i<nums.length; i++) {
            sum -= nums[i];
            diff[i] = Math.abs(diff[i] - sum);
        }
        return diff;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference(new int[] {10,4,8,3})));
        System.out.println(Arrays.toString(leftRightDifference(new int[] {10,4,8,3})));
    }
}

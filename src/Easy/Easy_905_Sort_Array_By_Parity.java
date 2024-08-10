// 905. Sort Array By Parity
package Easy;
import java.util.Arrays;

public class Easy_905_Sort_Array_By_Parity {
    public static int[] sortArrayByParity(int[] nums) {
        for (int i=0, even=0; i<nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[even];
                nums[even] = nums[i];
                nums[i] = temp;
                even++;
            }
        } return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {0})));
    }
}

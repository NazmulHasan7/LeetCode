// 2460. Apply Operations to an Array
package Easy;
import java.util.Arrays;

public class Easy_2460_Apply_Operations_to_an_Array {
    public static int[] applyOperations(int[] nums) {
        int length = nums.length;
        for (int i=0; i<length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int k = 0;
        for (int i=0; i<length; i++)
            if (nums[i] != 0)
                nums[k++] = nums[i];
        Arrays.fill(nums, k, length, 0);
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[] {1,2,2,1,1,0})));
        System.out.println(Arrays.toString(applyOperations(new int[] {0,1})));
    }
}

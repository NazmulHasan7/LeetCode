// 238. Product of Array Except Self
package Medium;
import java.util.Arrays;

public class Medium_238_Product_of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        int pre = 1, suf = 1;
        for (int i=0, j=length-1; i<nums.length; i++, j--) {
            prefix[i] = pre;
            suffix[j] = suf;
            pre *= nums[i];
            suf *= nums[j];
        }
        for (int i=0; i<length; i++)
            nums[i] = prefix[i] * suffix[i];
        return nums;
    }
    public static int[] productExceptSelfBetter(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        // Computing prefix multiplication
        int prefix = 1;
        for (int i=0; i<length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Computing suffix multiplication
        int suffix = 1;
        for (int i=length-1; i>=0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfBetter(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelfBetter(new int[] {-1,1,0,-3,3})));
    }
}

// 1464. Maximum Product of Two Elements in an Array
package Easy;
import java.util.Arrays;

public class Easy_1464_Maximum_Product_of_Two_Elements_in_an_Array {
    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
    }
    public static int maxProductBetter(int[] nums) {
        int max1, max2;
        max1 = max2 = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > max2) {
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else max2 = num;
            }
        } return (max1-1) * (max2-1);
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {3,4,5,2}));
        System.out.println(maxProduct(new int[] {1,5,4,5}));
        System.out.println(maxProduct(new int[] {3, 7}));
        System.out.println(maxProductBetter(new int[] {3,4,5,2}));
        System.out.println(maxProductBetter(new int[] {1,5,4,5}));
        System.out.println(maxProductBetter(new int[] {3, 7}));
    }
}

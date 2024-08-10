// 1913. Maximum Product Difference Between Two Pairs
package Easy;
import java.util.Arrays;

public class Easy_1913_Maximum_Product_Difference_Between_Two_Pairs {
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1] * nums[n-2] - nums[1] * nums[0]);
    }
    public static int maxProductDifferenceBetter(int[] nums) {
        int max1, max2, min1, min2;
        max1 = max2 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num > max2) {
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else max2 = num;
            }
            if (num < min2) {
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else min2 = num;
            }
        }
        // System.gc();
        return max1 * max2 - min1 * min2;
    }
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[] {5,6,2,7,4}));
        System.out.println(maxProductDifference(new int[] {4,2,5,9,7,4,8}));
        System.out.println(maxProductDifferenceBetter(new int[] {5,6,2,7,4}));
        System.out.println(maxProductDifferenceBetter(new int[] {4,2,5,9,7,4,8}));
    }
}

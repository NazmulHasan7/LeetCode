// 628. Maximum Product of Three Numbers
package Easy;

public class Easy_628_Maximum_Product_of_Three_Numbers {
    public static int maximumProduct(int[] nums) {
        int n = nums.length;
        /* Arrays.sort(nums);
        return Math.max(
                nums[n-1] * nums[n-2] * nums[n-3],
                nums[0] * nums[1] * nums[n-1]
        ); */
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;

        int min1 = Integer.MAX_VALUE;
        int min2 = min1;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = curr;
            } else if (curr >= max2) {
                max3 = max2;
                max2 = curr;
            } else if (curr >= max3) {
                max3 = curr;
            }

            if (curr <= min1) {
                min2 = min1;
                min1 = curr;
            } else if (curr <= min2) {
                min2 = curr;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1,2,3}));
        System.out.println(maximumProduct(new int[]{1,2,3,4}));
        System.out.println(maximumProduct(new int[]{-1,-2,-3}));
    }
}

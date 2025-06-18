// 2567. Minimum Score by Changing Two Elements
package Medium;
import java.util.Arrays;

public class Medium_2567_Minimum_Score_by_Changing_Two_Elements {
    public static int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // Case 1 -> changing first and last elements
        // num[n-2] <- num[n-1] and num[0] <- num[1]
        int case1 = nums[n-2] - nums[1]; // ignore lower case -> always 0

        // Case 2 -> changing first two elements
        // num[0] <- num[2] and num[1] <- num[2]
        int case2 = nums[n-1] - nums[2];

        // Case 3 -> changing last two elements
        // num[n-1] <- num[n-3] and num[n-2] <- num[n-3]
        int case3 = nums[n-3] - nums[0];

        return Math.min(case1, Math.min(case2, case3));
    }
    public static int minimizeSumOpt(int[] nums) {
        // Same approach without sorting
        int max1 = -1, max2 = -1, max3 = -1, min1 = Integer.MAX_VALUE, min2 = min1, min3 = min1;
        for(int num : nums) {
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if(num < min1) {
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min3 = num;
            }
        }
        return Math.min(max1-min3, Math.min(max2-min2, max3-min1));
    }
    public static void main(String[] args) {
        System.out.println(minimizeSum(new int[]{1,4,7,8,5}));
        System.out.println(minimizeSum(new int[]{1,4,3}));
    }
}

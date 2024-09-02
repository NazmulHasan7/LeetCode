// 976. Largest Perimeter Triangle
package Easy;
import java.util.Arrays;

public class Easy_976_Largest_Perimeter_Triangle {
    private static boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=n-1; i>=2; i--)
            if (isValidTriangle(nums[i], nums[i-1], nums[i-2]))
                return nums[i] + nums[i-1] + nums[i-2];
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2,1,2}));
        System.out.println(largestPerimeter(new int[]{1,2,1,10}));
    }
}

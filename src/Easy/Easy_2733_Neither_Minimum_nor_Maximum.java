// 2733. Neither Minimum nor Maximum
package Easy;
import java.util.Arrays;

public class Easy_2733_Neither_Minimum_nor_Maximum {
    public static int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if (n <= 2) return -1;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n-1];

        for (int i=1; i<n-1; i++)
            if (nums[i] != min && nums[i] != max)
                return nums[i];
        return -1;
    }
    public static int findNonMinOrMaxConstant(int[] nums) {
        if (nums.length <= 2) return -1;
        int a = nums[0], b = nums[1], c = nums[2];
        if ((a>b && a<c) || (a<b && a>c))
            return a;
        else if ((b>a && b<c) || (b<a && b>c))
            return b;
        else if ((c>a && c<b) || (c<a && c>b))
            return c;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findNonMinOrMax(new int[] {3,2,1,4}));
        System.out.println(findNonMinOrMax(new int[] {1,2}));
        System.out.println(findNonMinOrMax(new int[] {2,1,3}));
        System.out.println(findNonMinOrMaxConstant(new int[] {3,2,1,4}));
        System.out.println(findNonMinOrMaxConstant(new int[] {1,2}));
        System.out.println(findNonMinOrMaxConstant(new int[] {2,1,3}));
    }
}

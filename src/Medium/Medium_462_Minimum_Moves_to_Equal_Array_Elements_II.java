// 462. Minimum Moves to Equal Array Elements II
package Medium;
import java.util.Arrays;

public class Medium_462_Minimum_Moves_to_Equal_Array_Elements_II {
    // TC -> O(n log(n)), SC -> O(1)
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ops = 0;
        int median = nums[nums.length/2];

        for (int num : nums)
            ops += Math.abs(median - num);
        return ops;
    }
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,2,3}));
        System.out.println(minMoves2(new int[]{1,10,2,9}));
    }
}

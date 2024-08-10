// 1920. Build Array from Permutation
package Easy;
import java.util.Arrays;

public class Easy_1920_Build_Array_from_Permutation {
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] array = buildArray(new int[] {0, 2, 1, 5, 3, 4});
        System.out.println(Arrays.toString(array));
    }
}

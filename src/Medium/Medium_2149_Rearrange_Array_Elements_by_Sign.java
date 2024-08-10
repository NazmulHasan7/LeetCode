// 2149. Rearrange Array Elements by Sign
package Medium;
import java.util.Arrays;

public class Medium_2149_Rearrange_Array_Elements_by_Sign {
    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posIdx = 0, negIdx = 1;
        for (int num : nums) {
            if (num > 0) {
                result[posIdx] = num;
                posIdx += 2;
            } else {
                result[negIdx] = num;
                negIdx += 2;
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[] {3,1,-2,-5,2,-4})));
        System.out.println(Arrays.toString(rearrangeArray(new int[] {-1,1})));
    }
}

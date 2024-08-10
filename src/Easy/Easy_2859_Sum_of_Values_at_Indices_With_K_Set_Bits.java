// 2859. Sum of Values at Indices With K Set Bits
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_2859_Sum_of_Values_at_Indices_With_K_Set_Bits {
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++)
            if (k == Integer.bitCount(i))
                sum += nums.get(i);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumIndicesWithKSetBits(new ArrayList<>(Arrays.asList(5,10,1,5,2)), 1));
        System.out.println(sumIndicesWithKSetBits(new ArrayList<>(Arrays.asList(4,3,2,1)), 2));
    }
}

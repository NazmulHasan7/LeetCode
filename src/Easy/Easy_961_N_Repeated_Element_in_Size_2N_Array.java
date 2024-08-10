// 961. N-Repeated Element in Size 2N Array
package Easy;
import java.util.HashSet;

public class Easy_961_N_Repeated_Element_in_Size_2N_Array {
    public static int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num))
                return num;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[] {1,2,3,3}));
        System.out.println(repeatedNTimes(new int[] {2,1,2,5,3,2}));
        System.out.println(repeatedNTimes(new int[] {5,1,5,2,5,3,5,4}));
    }
}

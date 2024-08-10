// 2357. Make Array Zero by Subtracting Equal Amounts
package Easy;
import java.util.HashSet;

public class Easy_2357_Make_Array_Zero_by_Subtracting_Equal_Amounts {
    public static int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            if (num > 0) set.add(num);
        return set.size();
    }
    public static int minimumOperationsBetter(int[] nums) {
        boolean[] hash = new boolean[100];
        int distinctCount = 0;
        for (int num : nums) {
            if (num != 0 && !hash[num-1]) {
                hash[num-1] = true;
                distinctCount++;
            }
        } return distinctCount;
    }
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[] {1,5,0,3,5}));
        System.out.println(minimumOperations(new int[] {0}));
    }
}

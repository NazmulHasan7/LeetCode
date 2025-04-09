// 3375. Minimum Operations to Make Array Values Equal to K
package Easy;
import java.util.HashSet;

public class Easy_3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K {
    public static int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k)set.add(num);
        }
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{5,2,5,4,5}, 2));
        System.out.println(minOperations(new int[]{2,1,2}, 2));
        System.out.println(minOperations(new int[]{9,7,5,3}, 1));
    }
}

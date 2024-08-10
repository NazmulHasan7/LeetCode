// 217. Contains Duplicate
package Easy;
import java.util.HashSet;

public class Easy_217_Contains_Duplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num)) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,2,3,1}));
        System.out.println(containsDuplicate(new int[] {1,2,3,4}));
        System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
}

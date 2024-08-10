// 219. Contains Duplicate II
package Easy;
import java.util.HashSet;
import java.util.Set;

public class Easy_219_Contains_Duplicate_II {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i=0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                if (nums[i] == nums[j] && (j-i)<=k)
                    return true;
        return false;
    }
    public static boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i > k) set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}

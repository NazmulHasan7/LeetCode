// 2856. Minimum Array Length After Pair Removals
package Medium;
import java.util.Arrays;
import java.util.List;

public class Medium_2856_Minimum_Array_Length_After_Pair_Removals {
    public static int minLengthAfterRemovals(List<Integer> nums) {
        // As the array is sorted, numbers left in mid < numbers right in mid
        int n = nums.size();
        int right = n % 2 == 0 ? n/2 : n/2 + 1;

        int left = 0, removeCount = 0;
        while (right < n) {
            if (nums.get(left) < nums.get(right))
                removeCount += 2;
            left++;
            right++;
        } return n - removeCount;
    }
    public static void main(String[] args) {
        System.out.println(minLengthAfterRemovals(Arrays.asList(1,2,3,4)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(1,1,2,2,3,3)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(1000000000,1000000000)));
    }
}

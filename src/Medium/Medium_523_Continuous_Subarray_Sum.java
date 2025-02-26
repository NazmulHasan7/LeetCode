// 523. Continuous Subarray Sum
package Medium;
import java.util.HashMap;

public class Medium_523_Continuous_Subarray_Sum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        // Map -> remainder, index at which the remainder appears
        int sum = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i=0; i<n; i++) {
            sum += nums[i];
            int rem = sum % k;
            // if we already encountered the same rem before
            // then the sum of in between [prev rem idx -> curr idx] indices is divisible by k
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }
}

// 2762. Continuous Subarrays
package Medium;
import java.util.TreeMap;

public class Medium_2762_Continuous_Subarrays {
    // Sliding window approach
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        long count = 0;

        // Ordered map to keep track of the maximum and minimum value
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Keep sliding to the right
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Now check the condition, if the current sub-array violates it
            while (map.lastKey() - map.firstKey() > 2) {
                // Violates the condition, shrink the sub-array
                map.put(nums[left], map.getOrDefault(nums[left],0) - 1);

                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);

                left++;
            }
            // valid range
            count += (right - left) + 1;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
        System.out.println(continuousSubarrays(new int[]{1,2,3}));
    }
}

// 2831. Find the Longest Equal Sub-array
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium_2831_Find_the_Longest_Equal_Subarray {
    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int left = 0, right = 0;
        int maxFreq = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < nums.size()) {
            int num = nums.get(right);
            map.put(num, map.getOrDefault(num,0)+1);
            maxFreq = Math.max(maxFreq, map.get(num));

            // Check within the current window
            //  size -> The count of maximum frequency within the window
            while (right - left + 1 - maxFreq > k) {
                map.put(nums.get(left), map.get(nums.get(left))-1);
                left++;
            } right++;
        } return maxFreq;
    }
    public static int longestEqualSubarrayBetter(List<Integer> nums, int k) {
        int len = nums.size();
        int left = 0, right = 0, maxFreq = 0;
        int[] freq = new int[len+1];

        while (right < len) {
            if (right - left - maxFreq > k) {
                freq[nums.get(left)]--;
                left++;
            }
            freq[nums.get(right)]++;
            maxFreq = Math.max(maxFreq, freq[nums.get(right)]);
            right++;
        } return maxFreq;
    }
    public static void main(String[] args) {
        System.out.println(longestEqualSubarray(Arrays.asList(1,3,2,3,1,3), 3));
        System.out.println(longestEqualSubarrayBetter(Arrays.asList(1,1,2,2,1,1), 2));
    }
}

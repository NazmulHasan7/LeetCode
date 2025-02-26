// 3026. Maximum Good Subarray Sum
package Medium;
import java.util.HashMap;

public class Medium_3026_Maximum_Good_Subarray_Sum {
    public static long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, answer = Long.MIN_VALUE;
        // Map -> {number, sum}, stores prefix sum before the number
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(nums[0], 0L);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(num + k))
                answer = Math.max(answer, sum - map.get(num + k));
            if (map.containsKey(num - k))
                answer = Math.max(answer, sum - map.get(num - k));

            // To ensure the maximum sum store the duplicate entry only with the smallest prefix sum
            if (!map.containsKey(num) || sum - num < map.get(num))
                map.put(num, sum - num);
        }
        return answer == Long.MIN_VALUE ? 0 : answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1,2,3,4,5,6}, 1));
        System.out.println(maximumSubarraySum(new int[]{-1,3,2,4,5}, 3));
        System.out.println(maximumSubarraySum(new int[]{-1,-2,-3,-4}, 2));
    }
}

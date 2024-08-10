// 2958. Length of Longest Sub-array With at Most K Frequency
package Medium;
import java.util.HashMap;

public class Medium_2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, answer = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1));
        System.out.println(maxSubarrayLength(new int[]{5,5,5,5,5,5,5}, 4));
    }
}

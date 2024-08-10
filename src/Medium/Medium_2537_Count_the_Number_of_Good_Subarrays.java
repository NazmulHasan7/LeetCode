// 2537. Count the Number of Good Sub-arrays
package Medium;
import java.util.HashMap;

public class Medium_2537_Count_the_Number_of_Good_Subarrays {
    public static long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, pairCount = 0;
        int answer = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            // Number of pairs = previous frequency of the number
            pairCount += map.get(nums[right])-1;

            while (pairCount >= k) {
                answer += nums.length - right;
                map.put(nums[left], map.get(nums[left])-1);
                // Remove the contribution of the left number from pairs
                pairCount -= map.get(nums[left]);
                left++;
            } right++;
        } return answer;
    }
    public static long countGoodBetter(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, freq = 0;
        long pairCount = 0, answer = 0;

        while (right < nums.length) {
            if (map.containsKey(nums[right])) {
                freq = map.get(nums[right]);
                pairCount += freq;
                map.put(nums[right], freq + 1);
            } else {
                map.put(nums[right], 1);
            }
            while (pairCount >= k) {
                answer += (nums.length - right);
                freq = map.get(nums[left]);
                // Remove the contribution of the left number from pairs
                pairCount -= freq-1;
                map.put(nums[left], freq-1);
                left++;
            } right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(countGoodBetter(new int[]{1,1,1,1,1}, 10));
        System.out.println(countGoodBetter(new int[]{3,1,4,3,2,2,4},2));
    }
}

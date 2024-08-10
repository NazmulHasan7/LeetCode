// 1695. Maximum Erasure Value
package Medium;
import java.util.HashMap;

public class Medium_1695_Maximum_Erasure_Value {
    public static int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, answer = 0, windowSum = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            windowSum += nums[right];

            while (map.get(nums[right]) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                windowSum -= nums[left];
                left++;
            }
            right++;
            answer = Math.max(answer, windowSum);
        } return answer;
    }
    public static int maximumUniqueSubarrayBetter(int[] nums) {
        int left = 0, right = 0, windowSum = 0, answer = 0;
        boolean[] visited = new boolean[10001];

        while (right < nums.length) {
            windowSum += nums[right];
            while (visited[nums[right]]) {
                visited[nums[left]] = false;
                windowSum -= nums[left];
                left++;
            }
            // Mark current number as visited
            visited[nums[right]] = true;
            right++;
            answer = Math.max(answer, windowSum);
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
        System.out.println(maximumUniqueSubarrayBetter(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarrayBetter(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}

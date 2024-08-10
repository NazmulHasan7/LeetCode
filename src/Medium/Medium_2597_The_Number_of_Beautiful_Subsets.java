// 2597. The Number of Beautiful Subsets
package Medium;
import java.util.HashMap;

public class Medium_2597_The_Number_of_Beautiful_Subsets {
    static int answer;
    public static int beautifulSubsets(int[] nums, int k) {
        answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        backtrack(nums, 0, k, map);
        return answer;
    }
    private static void backtrack(int[] nums, int idx, int k, HashMap<Integer, Integer> map) {
        if (idx == nums.length) {
            if (!map.isEmpty()) answer++;
            return;
        }
        // Pick the current element if it doesn't violate the condition
        if (!map.containsKey(nums[idx] + k) && !map.containsKey(nums[idx] - k)) {
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
            backtrack(nums, idx + 1, k, map);
            // Undo the pick
            map.put(nums[idx], map.get(nums[idx]) - 1);
            if (map.get(nums[idx]) == 0) map.remove(nums[idx]);
        }
        // Not pick the current element
        backtrack(nums, idx + 1, k, map);
    }
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{2,4,6},2));
        System.out.println(beautifulSubsets(new int[]{1},1));
    }
}

// 491. Non-decreasing Subsequences
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_491_Non_decreasing_Subsequences {
    static List<List<Integer>> answer;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        answer = new ArrayList<>();
        backtrack(0, Integer.MIN_VALUE, nums, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int idx, int last, int[] nums, List<Integer> temp) {
        if (idx == nums.length) {
            if (temp.size() > 1)
                answer.add(new ArrayList<>(temp));
            return;
        }
        if (nums[idx] >= last) {
            // Pick
            temp.add(nums[idx]);
            backtrack(idx+1, nums[idx], nums, temp);
            temp.remove(temp.size()-1);
        }
        // Not pick, also need to avoid duplicates
        if (nums[idx] != last)
            backtrack(idx+1, last, nums, temp);
    }
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4,6,7,7}));
        System.out.println(findSubsequences(new int[]{4,4,3,2,1}));
    }
}

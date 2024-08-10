// 46. Permutations
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_46_Permutations {
    static List<List<Integer>> answer;
    public static List<List<Integer>> permute(int[] nums) {
        // Time -> O(n*n!), Space -> O(n) [Stack]
        answer = new ArrayList<>();
        backtrack(nums, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int[] nums, List<Integer> temp) {
        // Base case : Matches the length, a permutation found
        if (temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int number : nums) {
            // Skip same elements
            if (temp.contains(number)) continue;
            // Choose to add the current value
            temp.add(number);
            // Go back and try other values
            backtrack(nums, temp);
            // Choose NOT to add the current value
            temp.removeLast();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = permute(new int[]{1,2,3});
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = permute(new int[]{0,1});
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

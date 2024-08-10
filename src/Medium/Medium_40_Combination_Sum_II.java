// 40. Combination Sum II
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_40_Combination_Sum_II {
    static List<List<Integer>> answer;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int[] candidates, int idx, int target, List<Integer> temp) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        if (idx >= candidates.length) return;

        if (candidates[idx] <= target) {
            // Pick the current index element
            temp.add(candidates[idx]);
            backtrack(candidates, idx+1, target-candidates[idx], temp);
            temp.removeLast();

            // Skip the duplicates
            while (idx+1 < candidates.length && candidates[idx] == candidates[idx+1])
                idx++;
        }
        // Undo the pick and move to the index element
        backtrack(candidates, idx+1, target, temp);
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

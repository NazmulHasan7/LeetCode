// 39. Combination Sum
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_39_Combination_Sum {
    static List<List<Integer>> answer;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        backtrack(0, candidates.length, candidates, target, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int idx, int n, int[] candidates, int target, List<Integer> temp) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        if (idx == n) return;

        if (candidates[idx] <= target) {
            // Pick and add the current element
            temp.add(candidates[idx]);
            backtrack(idx, n, candidates, target-candidates[idx], temp);
            // Undo the pick
            temp.removeLast();
        }
        backtrack(idx+1, n, candidates, target, temp);
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = combinationSum(new int[]{2,3,6,7},7);
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = combinationSum(new int[]{2,3,5},8);
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = combinationSum(new int[]{2},1);
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

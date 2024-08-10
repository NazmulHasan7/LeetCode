// 216. Combination Sum III
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_216_Combination_Sum_III {
    static List<List<Integer>> answer;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        answer = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int k, int n, int start, List<Integer> temp) {
        if (k == 0 && n == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        if (n < 0 || k < 0 || start > 9) return;

        // Include the current number
        temp.add(start);
        backtrack(k-1, n-start, start+1, temp);
        // Exclude the current number and move to the next
        temp.removeLast();
        backtrack(k, n, start+1, temp);
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = combinationSum3(3,7);
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = combinationSum3(4,1);
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = combinationSum3(3,9);
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

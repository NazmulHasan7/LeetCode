// 77. Combinations
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_77_Combinations {
    static List<List<Integer>> answer;
    public static List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int idx, int n, int k, List<Integer> temp) {
        if (k == 0) {
            // k numbers to be chosen
            answer.add(new ArrayList<>(temp));
            return;
        }
        // Numbers chosen from the range [1, n]
        if (idx > n) return;
        // Choose to add the current number
        temp.add(idx);
        backtrack(idx+1, n, k-1, temp);
        // Chose NOT to add the current number
        temp.removeLast();
        backtrack(idx+1, n, k, temp);
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = combine(4,2);
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = combine(1,1);
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

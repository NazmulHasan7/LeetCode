// 78. Subsets
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_78_Subsets {
    static List<List<Integer>> answer;
    public static List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int index, int[] nums, List<Integer> temp) {
        if (index >= nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        // Choose to add the current index value
        temp.add(nums[index]);
        backtrack(index+1, nums, temp);
        // Choose NOT tp add the current index value
        temp.removeLast();
        backtrack(index+1, nums, temp);
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = subsets(new int[]{1,2,3});
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = subsets(new int[]{0});
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

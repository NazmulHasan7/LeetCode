// 90. Subsets II
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_90_Subsets_II {
    static List<List<Integer>> answer;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return answer;
    }
    private static void backtrack(int index, int[] nums, List<Integer> temp) {
        answer.add(new ArrayList<>(temp));
        for (int i=index; i<nums.length; i++) {
            if (i > index && nums[i] == nums[i-1])
                continue; // Skip the duplicate

            // Choose to add the current index value
            temp.add(nums[i]);
            backtrack(i+1, nums, temp);
            // Choose NOT to add the current index value
            temp.removeLast();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> answer = subsetsWithDup(new int[]{1,2,3});
        for (List<Integer> arr : answer) System.out.println(arr);
        answer = subsetsWithDup(new int[]{0});
        for (List<Integer> arr : answer) System.out.println(arr);
    }
}

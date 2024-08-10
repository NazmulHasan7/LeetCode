// 2089. Find Target Indices After Sorting Array
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_2089_Find_Target_Indices_After_Sorting_Array {
    public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        List<Integer> answer = new ArrayList<>();

        while (start <= end) {
            if (nums[start] == target)
                answer.add(start++);
            else if (nums[start] < target)
                start++;
            if (nums[end] > target)
                end--;
        } return answer;
    }
    public static List<Integer> targetIndicesBetter(int[] nums, int target) {
        List<Integer> answer = new ArrayList<>();
        int equalCount = 0, lessCount = 0;

        for (int num : nums) {
            if (num < target) lessCount++;
            else if (num == target) equalCount++;
        }
        while (equalCount-- > 0)
            answer.add(lessCount++);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(targetIndicesBetter(new int[]{1,2,5,2,3},2));
        System.out.println(targetIndicesBetter(new int[]{1,2,5,2,3},3));
        System.out.println(targetIndicesBetter(new int[]{1,2,5,2,3},5));
        System.out.println(targetIndicesBetter(new int[]{1},2));
    }
}
